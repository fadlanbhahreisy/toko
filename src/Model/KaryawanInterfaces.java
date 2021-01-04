/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.KasirEntity;
import Entity.SalesEntity;
import java.util.ArrayList;

/**
 *
 * @author alan
 */
public interface KaryawanInterfaces {
    public void insert_karyawan(SalesEntity sales,KasirEntity kasir);
    public ArrayList<SalesEntity> getDataSales();
    public ArrayList<KasirEntity> getDataKasir();   
}
