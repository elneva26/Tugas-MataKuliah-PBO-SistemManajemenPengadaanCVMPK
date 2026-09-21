/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */
public class Barang {
    
     private int idBarang;
    private String nama;
    private int stok;

    public Barang(int idBarang, String nama, int stok) {
        setIdBarang(idBarang);
        setNama(nama);
        setStok(stok);
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int barang) {
        if (barang <= 0) {
            System.out.println("==================================================================");
            System.out.println("ID barang tidak valid                                             ");
            System.out.println("==================================================================");
            return;
        }
        this.idBarang = barang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Nama barang tidak boleh kosong!                                   ");
            System.out.println("==================================================================");
            return;
        }
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("==================================================================");
            System.out.println("Stok tidak boleh kurang dari 0.                                   ");
            System.out.println("==================================================================");
            return;
        }
        this.stok = stok;
    }
    public void tampilkanInfo() {
        System.out.println("ID Barang:"+ idBarang);
        System.out.println("Nama:"+ nama);
        System.out.println("Stok:"+ stok);        
    }
}

