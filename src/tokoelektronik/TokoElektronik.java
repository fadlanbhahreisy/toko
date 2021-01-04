/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoelektronik;
import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import Entity.*;
/**
 *
 * @author alan
 */

public class TokoElektronik {
    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static ArrayList <PemesananModel> pesan = new ArrayList();
    static ArrayList <TransaksiModel> trans = new ArrayList();
    static ModelKaryawan Karyawan = new ModelKaryawan();
    static StokModel stok = new StokModel();
    static ArrayList <BarangEntity> tempKeranjang = new ArrayList(); // data temporary hanya bersifat sementara
    public static void main(String[] args) {
        int pil;
        data_karyawan();
        data_stok_barang();
        do{
        System.out.println("1. Sales");
        System.out.println("2. Kasir");
        System.out.println("0. Exit");
        System.out.print("Pilih -> ");
        pil = input.nextInt();
        switch (pil){
            case 1:
                pemesanan();
                break;
            case 2:
                transaksi();
                break;
        }
        }while(pil!=0);
    }
    
    //data karyawan statis
    public static void data_karyawan(){
        String id_sales[] = {"1","2"};
        String nama_sales[] = {"John", "Jane"};
        String pass_sales[] = {"john","jane"};
        
        String id_kasir[] = {"1","2"};
        String nama_kasir[] = {"Freddy", "Jason"};
        String pass_kasir[] = {"freedy","jason"};
        
        for(int i=0;i<id_sales.length;i++){
            Karyawan.insert_karyawan(new SalesEntity(id_sales[i],nama_sales[i],pass_sales[i]), 
                    new KasirEntity(id_kasir[i],nama_kasir[i],pass_kasir[i]));
        }
    }
    
    //data barang statis
    public static void data_stok_barang(){
        String nama_barang[] = {"tv","laptop","printer"};
        Double harga_barang[] = {5000000.0,7000000.0,3000000.0};
        for(int i=0;i<nama_barang.length;i++){
            stok.insert_stok(new BarangEntity(nama_barang[i],harga_barang[i]));
        }
    }
    
 
    public static void pemesanan(){
        System.out.println("Login Sales");
        System.out.print("Nama Sales = ");
        String nama_sales = input.next();
        System.out.print("Password Sales = ");
        String pass_sales = input.next();
        int index=0,pil;
        String ulang;
        boolean ketemu = false;
        for(int i= 0;i<Karyawan.getDataSales().size();i++){
            if(nama_sales.equals(Karyawan.getDataSales().get(i).getNama())&&
                    pass_sales.equals(Karyawan.getDataSales().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            do{
                System.out.println("1. input data pesanan");
                System.out.println("2. logout");
                System.out.print("pilih = ");
                pil = input.nextInt();
                if (pil==1){
                    System.out.print("Id Pesan = ");
                    String id_pesan = input.next();
                    System.out.print("Nama Pelanggan = ");
                    String nama_pel = input.next();

                    do{
                    System.out.println("pilih barang");
                    for(int i=0;i<stok.getStok().size();i++){
                        System.out.println(i+" "+stok.getStok().get(i).getNama_barang()+" "+stok.getStok().get(i).getHarga_barang());
                    }
                        System.out.print("pilih = ");
                        int pilih = input.nextInt();
                        tempKeranjang.add(stok.getStok().get(pilih));
                        System.out.println("beli lagi ? (y/n) = ");
                        ulang = input.next();
                    }while(ulang.equals("y")||ulang.equals("Y"));

                    pesan.add(new PemesananModel(id_pesan,nama_pel,Karyawan.getDataSales().get(index),tempKeranjang));
                    tempKeranjang = new ArrayList();
                }
            }while(pil!=2);
            view_pesan();
        }else{
            System.out.println("nama dan password tidak cocok");
        }
        
    }
    
    public static void view_pesan(){
        for(int i=0;i<pesan.size();i++){
            System.out.println("nama pembeli = "+pesan.get(i).getNama());
            System.out.println("nama sales = "+pesan.get(i).getSales().getNama());
            System.out.println("barang pesanan");
            for(int j=0;j<pesan.get(i).getKeranjang().size();j++){
                System.out.println((j+1)+". "+pesan.get(i).getKeranjang().get(j).getNama_barang()+" || "+pesan.get(i).getKeranjang().get(j).getHarga_barang());
            }
            System.out.println("Total Harga = "+pesan.get(i).total_harga());
        }
    }
    public static void transaksi(){
        System.out.print("Nama Kasir = ");
        String nama_kasir = input.next();
        System.out.print("Password Kasir = ");
        String pass_kasir = input.next();
        int index=0,pil;
        boolean ketemu = false;
        double total = 0;
        for(int i= 0;i<Karyawan.getDataKasir().size();i++){
            if(nama_kasir.equals(Karyawan.getDataKasir().get(i).getNama())&&
                    pass_kasir.equals(Karyawan.getDataKasir().get(i).getPassword())){
                index = i;
                ketemu = true;
            }
        }
        if(ketemu == true){
            System.out.println("1. Transaksi");
            System.out.println("2. Logout");
            System.out.print("Pilih = ");
            pil = input.nextInt();
            if(pil==1){
                System.out.print("Id Pesan = ");
                String id_pesan = input.next();
                for(int i = 0;i<pesan.size();i++){
                    if(id_pesan.equals(pesan.get(i).getId_pesan())){
                        System.out.println("Nama Pembeli = "+pesan.get(i).getNama());
                        System.out.println("Nama Sales = "+pesan.get(i).getSales().getNama());
                        total = pesan.get(i).total_harga();
                        view_pesan();
                    }
                }
                System.out.print("Bayar = ");
                double bayar=input.nextDouble();
                System.out.println("Sistem Bayar = ");
                for(int i=0;i<PembayaranEntity.barang.length;i++){
                    System.out.println(i+". "+PembayaranEntity.barang[i]);
                }
                System.out.print("Pilih = ");
                int pilih = input.nextInt();
                trans.add(new TransaksiModel(Karyawan.getDataKasir().get(index),pilih));
                System.out.println("Kembali = "+(bayar-total));
            }
        }else{
            System.out.println("nama atau password tidak cocok");
        }
    }
}

