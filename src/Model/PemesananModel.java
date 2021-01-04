/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alan
 */
import Entity.SalesEntity;
import Entity.BarangEntity;
import java.util.ArrayList;
public class PemesananModel {
    private String id_pesan,nama;
    private SalesEntity sales;
    private ArrayList <BarangEntity> Keranjang = new ArrayList();
    
    public PemesananModel(String id_pesan, String nama, SalesEntity sales, ArrayList<BarangEntity> Keranjang) {
        this.id_pesan = id_pesan;
        this.nama = nama;
        this.sales = sales;
        this.Keranjang = Keranjang;
    }

    public String getId_pesan() {
        return id_pesan;
    }

    public String getNama() {
        return nama;
    }

    public SalesEntity getSales() {
        return sales;
    }

    public ArrayList<BarangEntity> getKeranjang() {
        return Keranjang;
    }
    public double total_harga(){
        double total = 0;
        for(int i=0;i<Keranjang.size();i++){
            total = total + Keranjang.get(i).getHarga_barang();
        }
        return total;
    }

}

