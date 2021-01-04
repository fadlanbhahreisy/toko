/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.BarangEntity;
import java.util.ArrayList;
/**
 *
 * @author alan
 */
public class StokModel {
    private ArrayList <BarangEntity> stok;
    
    public StokModel(){
        stok = new ArrayList();
    }
    
    public void insert_stok(BarangEntity barang){
        stok.add(barang);
    }

    public ArrayList<BarangEntity> getStok() {
        return stok;
    }
}
