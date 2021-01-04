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
import Entity.KasirEntity;
import Entity.PembayaranEntity;
public class TransaksiModel {
    KasirEntity kasir;
    int index_bayar;

    public KasirEntity getKasir() {
        return kasir;
    }

    public int getIndex_bayar() {
        return index_bayar;
    }

    public TransaksiModel(KasirEntity kasir, int index_bayar) {
        this.kasir = kasir;
        this.index_bayar = index_bayar;
    }
    public double kembalian(double harga,double bayar){
        double kembali;
        kembali = bayar-harga;
        return kembali;
    }
}
