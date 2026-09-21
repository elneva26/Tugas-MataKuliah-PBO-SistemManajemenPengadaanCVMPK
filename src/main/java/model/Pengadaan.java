/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */
public class Pengadaan {
    private int idPengadaan;
    private String tanggal;
    private String alamat;

    public Pengadaan(int idPengadaan, String tanggal, String alamat) {
        this.idPengadaan = idPengadaan;
        this.tanggal = tanggal; 
        this.alamat = alamat;
    }

    public int getIdPengadaan() {
        return idPengadaan;
    }

    public void setIdPengadaan(int idPengadaan) {
        if (idPengadaan <=0){
            System.out.println("==================================================================");
            System.out.println("ID pengadaan tidak valid.                                         ");
            System.out.println("==================================================================");
            return;
        }
        this.idPengadaan = idPengadaan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        if (tanggal == null || tanggal.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println(">> Tanggal pengadaan tidak boleh kosong!                          ");
            System.out.println("==================================================================");
            return;
        }
        this.tanggal = tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat == null || alamat.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Alamat pengadaan tidak boleh kosong!                              ");
            System.out.println("==================================================================");
            return;
        }
        this.alamat = alamat;
    }
}
