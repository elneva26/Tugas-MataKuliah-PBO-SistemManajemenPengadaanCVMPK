/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS FC
 */

public class Laptop extends BarangElektronik {

    private String processor;

    public Laptop(int idBarang, String nama, int stok, String garansi, String processor) {
        super(idBarang, nama, stok, garansi);
        setProcessor(processor);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        if (processor == null || processor.trim().isEmpty()) {
            System.out.println("Processor tidak boleh kosong.");
            return;
        }
        this.processor = processor;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("==================================================================");
        System.out.println("                              LAPTOP                              ");
        System.out.println("==================================================================");
        System.out.println("ID Barang  : " + getIdBarang());
        System.out.println("Nama       : " + getNama());
        System.out.println("Stok       : " + getStok());
        System.out.println("Garansi    : " + getGaransi());
        System.out.println("Processor  : " + processor);
        System.out.println("==================================================================");
    }
}

