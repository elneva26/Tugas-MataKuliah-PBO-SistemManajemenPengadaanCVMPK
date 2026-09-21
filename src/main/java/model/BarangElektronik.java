/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */
public class BarangElektronik extends Barang {
    
    private String garansi;

    public BarangElektronik(int idBarang, String nama, int stok, String garansi) {
        super(idBarang, nama, stok);
        setGaransi(garansi);
    }

    public String getGaransi() {
        return garansi;
    }

    public void setGaransi(String garansi) {
        if (garansi == null || garansi.trim().isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("Garansi tidak boleh kosong.                                   ");
            System.out.println("==============================================================");
            return;
        }
        this.garansi = garansi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("==================================================================");
        System.out.println("                           BARANG ELEKTRONIK                      ");
        System.out.println("==================================================================");
        System.out.println("ID Barang:"+ getIdBarang()                                         );
        System.out.println("Nama:"+ getNama()                                                  );
        System.out.println("Stok:"+ getStok()                                                  );
        System.out.println("Garansi:"+ garansi                                                 );
        System.out.println("==================================================================");
    }
}

