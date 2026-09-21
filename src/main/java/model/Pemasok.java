/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */
public class Pemasok {
    
    private int idPemasok;
    private String nama;
    private String alamat;
    private String noTelepon;

    public Pemasok(int idPemasok, String nama, String alamat, String noTelepon) {
        setIdPemasok(idPemasok);
        setNama(nama);
        setAlamat(alamat);
        setNoTelepon(noTelepon);
    }

    public int getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(int idPemasok) {
        if (idPemasok <= 0) {
            System.out.println("==================================================================");
            System.out.println("ID pemasok tidak valid                                            ");
            System.out.println("==================================================================");
            return;
        }
        this.idPemasok = idPemasok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Nama pemasok tidak boleh kosong dan wajib diisi!                  ");
            System.out.println("==================================================================");
            return;
        }
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat == null || alamat.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Alamat tidak boleh kosong dan wajib diisi!                        ");
            System.out.println("==================================================================");
            return;
        }
        this.alamat= alamat;

    }
    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null || noTelepon.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("no telepon tidak boleh kosong dan wajib diisi!                    ");
            System.out.println("==================================================================");
            return;
        }
        this.noTelepon = noTelepon;
    
    }
}
