/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */
public class BarangNonElektronik extends Barang {
    
    private String kategori;

    public BarangNonElektronik(int idBarang, String nama, int stok, String kategori) {
        super(idBarang, nama, stok);
        setKategori(kategori);
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Kategori tidak boleh kosong.                                      ");
            System.out.println("==================================================================");
            return;
        }
        this.kategori = kategori;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("==================================================================");
        System.out.println("                          BARANG NON ELEKTRONIK                   ");
        System.out.println("==================================================================");
        System.out.println("ID Barang:"+ getIdBarang()                                         );
        System.out.println("Nama:"+ getNama()                                                  );
        System.out.println("Stok:"+ getStok()                                                  );
        System.out.println("Garansi:"+ kategori                                                );
        System.out.println("==================================================================");
    }
}

