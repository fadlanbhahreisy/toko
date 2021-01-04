/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author alan
 */
public class BarangEntity {
    protected String nama_barang;
    protected double harga_barang;

    public BarangEntity(String nama_barang, double harga_barang) {
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public double getHarga_barang() {
        return harga_barang;
    }
    
}
