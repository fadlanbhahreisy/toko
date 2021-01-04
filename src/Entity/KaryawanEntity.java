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


//parent class
public class KaryawanEntity {
    protected String id,nama,password;

    public KaryawanEntity(String id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }
    
}
