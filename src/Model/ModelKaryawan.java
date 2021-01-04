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
import Entity.SalesEntity;
import java.util.ArrayList;
//relasi realization dgn interfaces
public class ModelKaryawan implements KaryawanInterfaces{
    ArrayList <SalesEntity> dataSales;
    ArrayList <KasirEntity> dataKasir;
    
    // composition dari SalesEntity dan KasirEntity membentuk satu class karyawanmodel
    public ModelKaryawan(){
        dataSales = new ArrayList();
        dataKasir = new ArrayList();
    }
    
    //polymorphism override karena memiliki method yang sama seperti interfaces
    
    @Override
    public void insert_karyawan(SalesEntity sales,KasirEntity kasir){
        dataSales.add(sales);
        dataKasir.add(kasir);
    }

    @Override
    public ArrayList<SalesEntity> getDataSales() {
        return dataSales;
    }

    @Override
    public ArrayList<KasirEntity> getDataKasir() {
        return dataKasir;
    }

}
