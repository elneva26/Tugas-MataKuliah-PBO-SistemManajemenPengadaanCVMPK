/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Barang;
import model.BarangElektronik;
import model.BarangNonElektronik;
import model.Pemasok;
import model.Pengadaan;


public class Service {
    
    private ArrayList<Barang> daftarBarang;
    private ArrayList<Pemasok> daftarPemasok;
    private ArrayList<Pengadaan> daftarPengadaan;
    
    
    private Scanner scanner;
    
    public Service(Scanner scanner){
        this.scanner = scanner;
        
        daftarBarang = new ArrayList<>();
        daftarPemasok = new ArrayList<>();
        daftarPengadaan = new ArrayList<>();
        
        daftarBarang.add(
                new BarangElektronik(
                        1,
                        "Laptop ASUS",
                        10,
                        "2 Tahun"
                )
        );

        daftarBarang.add(
                new BarangNonElektronik(
                        2,
                        "Meja Kantor",
                        5,
                        "Perlengkapan Kantor"
                )
        );

        daftarPemasok.add(
                new Pemasok(
                        1,
                        "PT Sumber Elektronik",
                        "Samarinda",
                        "081234567890"
                )
        );

        daftarPengadaan.add(
                new Pengadaan(
                        1,
                        "18/09/2026",
                        "Gudang CV MPK"
                )
        );
    }
    
    public void menuBarang() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println("==================================================================");
            System.out.println("                      KELOLA DATA BARANG                          ");
            System.out.println("==================================================================");
            System.out.println("1. Tambah Barang                                                  ");
            System.out.println("2. Tampilkan Barang                                               ");
            System.out.println("3. Hapus Barang                                                   ");
            System.out.println("4. Update Stok                                                    ");
            System.out.println("5. Kembali                                                        ");
            System.out.println("==================================================================");
            System.out.print("Pilih menu:                                                         ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> hapusBarang();
                case 4 -> updateStok();
                case 5 -> kembali = true;
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
   
    public void tambahBarang(){
        
        System.out.println("==================================================================");
        System.out.println("                       TAMBAH DATA BARANG                         ");
        System.out.println("==================================================================");
        
        int id;
        
        while (true) {
           
        System.out.print("ID Barang: "); 
        
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
            scanner.nextLine();
         
        if (id > 0){
            break;
        } else {
            System.out.println("==================================================================");
            System.out.println("ID barang harus lebih dari nilai 0.                               ");
            System.out.println("==================================================================");
            return;
        }
        } else {
            System.out.println("==================================================================");
            System.out.println("ID barang harus diisi dengan angka!                               ");
            System.out.println("==================================================================");
            scanner.nextLine();
        }
    }

        System.out.print("Nama Barang: "); 
        String nama = scanner.nextLine();
        
        if(nama.trim().isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Nama barang tidak boleh kosong!                                   ");
            System.out.println("==================================================================");
            return;
        }

        int stok;
        
        while (true) {
           
        System.out.print("Stok Barang: "); 
        
        if (scanner.hasNextInt()) {
            stok = scanner.nextInt();
            scanner.nextLine();
         
        if (stok >= 0){
            break;
        } else {
            System.out.println("==================================================================");
            System.out.println("Stok tidak boleh kurang dari 0!                                   ");
            System.out.println("==================================================================");
            return;
        }
        } else {
            System.out.println("==================================================================");
            System.out.println("Stok harus diisi dengan angka!                                    ");
            System.out.println("==================================================================");
            scanner.nextLine();
        }
    }
        System.out.println("\nJenis Barang:");
        System.out.println("1. Barang Elektronik");
        System.out.println("2. Barang Non-Elektronik");
        System.out.print("Pilih jenis: ");

        int jenis;
        
        while (true) {
           
        System.out.print("Pilih jenis: "); 
        
        if (scanner.hasNextInt()) {
            jenis = scanner.nextInt();
            scanner.nextLine();
         
        if (jenis == 1 || jenis == 2){
            break;
        } else {
            System.out.println("==================================================================");
            System.out.println("Jenis barang hanya boleh memilih 1 atau 2!                        ");
            System.out.println("==================================================================");
            return;
        }
        } else {
            System.out.println("==================================================================");
            System.out.println("Jenis barang harus diisi dengan angka!                            ");
            System.out.println("==================================================================");
            scanner.nextLine();
        }
    }

        Barang barangBaru;

        if (jenis == 1) {

            System.out.print("Garansi: ");
            String garansi = scanner.nextLine();

            if (garansi.trim().isEmpty()) {
                System.out.println("==================================================================");
                System.out.println("Garansi wajib diisi dan tidak boleh kosong                        ");
                System.out.println("==================================================================");
                return;
            }

            barangBaru = new BarangElektronik(
                    id,
                    nama,
                    stok,
                    garansi
            );

        } else if (jenis == 2) {

            System.out.print("Kategori: ");
            String kategori = scanner.nextLine();

            if (kategori.trim().isEmpty()) {
                System.out.println("==================================================================");
                System.out.println("Kategori tidak boleh kosong.                                      ");
                System.out.println("==================================================================");
                return;
            }

            barangBaru = new BarangNonElektronik(
                    id,
                    nama,
                    stok,
                    kategori
            );

        } else {
            System.out.println("=====================================================================");
            System.out.println("Jenis barang tidak tersedia! mohon data dicek kembali                ");
            System.out.println("=====================================================================");
            return;
        }
        
        daftarBarang.add(barangBaru);

        System.out.println("=========================================================================");
        System.out.println(">> Barang baru berhasil ditambahkan!                                     ");
        System.out.println("=========================================================================");
    }
    public void tampilkanBarang() {
    if (daftarBarang.isEmpty()) {
        System.out.println("=========================================================================");
        System.out.println(">> Data barang masih kosong!                                             ");
        System.out.println("=========================================================================");
        return;
    }

    System.out.println("==================================================================");
    System.out.println("                            DAFTAR BARANG                         ");
    System.out.println("==================================================================");
    
    System.out.println();
    System.out.println("|-- BARANG ELEKTRONIK");
    System.out.println();
   
    for (Barang b : daftarBarang) {
       if (b instanceof BarangElektronik) {   
       b.tampilkanInfo();
    }
}
    
    System.out.println();
    System.out.println("|-- BARANG NON - ELEKTRONIK");
    System.out.println();
    
    for (Barang b : daftarBarang) {
        if (b instanceof BarangNonElektronik) {
            b.tampilkanInfo();
        }
    }
    System.out.println("==================================================================");
    System.out.println("                      DATA SELESAI DITAMPILKAN                    ");
    System.out.println("==================================================================");
}
    public void hapusBarang(){
        System.out.print("Masukkan ID Barang: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();
        
        boolean ditemukan = false;

        for(int i = 0; i < daftarBarang.size(); i++){
            if(daftarBarang.get(i).getIdBarang() == idTarget){    
                daftarBarang.remove(i);
                System.out.println("==================================================================");
                System.out.println(">> Barang berhasil dihapus!                                       ");
                System.out.println("==================================================================");
                
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("======================================================================");
            System.out.println("ID barang tidak ditemukan                                             ");
            System.out.println("======================================================================");
        }
    }
    
    public void updateStok(){
        System.out.print("Masukkan ID Barang: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Barang b : daftarBarang){
            if(b.getIdBarang() == idTarget){
                System.out.println("Stok Baru: ");
                int stokBaru = scanner.nextInt(); 
                scanner.nextLine();
                
                if (stokBaru < 0) {
                    System.out.println("==============================================================");
                    System.out.println("Stok tidak boleh kurang dari 0                                ");
                    System.out.println("==============================================================");
                    return;
                }
               
                b.setStok(stokBaru);
                System.out.println("==================================================================");
                System.out.println(">> Stok barang berhasil diperbarui!                               ");
                System.out.println("==================================================================");
                return;
            }
        }
        System.out.println("==========================================================================");
        System.out.println("ID barang tidak ditemukan.                                                ");
        System.out.println("==========================================================================");
}
    public void menuPemasok() {

    boolean kembali = false;

    while (!kembali) {

        System.out.println("==========================================================================");
        System.out.println("                              KELOLA DATA PEMASOK                         ");
        System.out.println("==========================================================================");
        System.out.println("1. Tambah Pemasok                                                         ");
        System.out.println("2. Tampilkan Pemasok                                                      ");
        System.out.println("3. Hapus Pemasok                                                          ");
        System.out.println("4. Update Pemasok                                                         ");
        System.out.println("5. Kembali                                                                ");
        System.out.println("==========================================================================");
        System.out.print("Pilih menu:                                                                 ");
        
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1 -> tambahPemasok();
            case 2 -> tampilkanPemasok();
            case 3 -> hapusPemasok();
            case 4 -> updatePemasok();
            case 5 -> kembali = true;
            default -> System.out.println("Pilihan tidak valid!");
        }
    }
}
    public void tambahPemasok(){
        System.out.println("==========================================================================");
        System.out.println("                               TAMBAH PEMASOK                             ");
        System.out.println("==========================================================================");
        
        
        int idPemasok;
        do {System.out.println("ID Pemasok:");
            idPemasok = scanner.nextInt();
            scanner.nextLine();
            
            if (idPemasok <= 0) {
                System.out.println("==================================================================");
                System.out.println("ID pemasok harus lebih dari 0!                                    ");   
                System.out.println("==================================================================");
            }
        } while (idPemasok <= 0);
        
        String nama;
        do {System.out.println("Nama Pemasok");
            nama = scanner.nextLine();
        
            if (nama.trim().isEmpty()) {
                System.out.println("==================================================================");
                System.out.println("Nama pemasok wajib diisi!                                         ");
                System.out.println("==================================================================");
            }
        } while (nama.trim().isEmpty());
        
        String alamat;
        
        do { System.out.print("Alamat Pemasok: "); 
             alamat = scanner.nextLine();
             
             if (alamat.trim().isEmpty()) {
                 System.out.println("==================================================================");
                 System.out.println("Alamat pemasok wajib diisi!                                       ");
                 System.out.println("==================================================================");
             }
        } while (alamat.trim().isEmpty());
        
        String noTelepon;
        do {System.out.println("No telepon: ");
            noTelepon = scanner.nextLine();
            
            if (noTelepon.trim().isEmpty()) {
                System.out.println("==================================================================");
                System.out.println("No telepon wajib diisi!                                           ");
                System.out.println("==================================================================");
            }
        } while (noTelepon.trim().isEmpty());

        daftarPemasok.add(new Pemasok(idPemasok, nama, alamat, noTelepon));

        System.out.println("==========================================================================");
        System.out.println(">> Pemasok baru berhasil ditambahkan!                                     ");
        System.out.println("==========================================================================");
        }
    public void tampilkanPemasok(){
        if (daftarPemasok.isEmpty()) {
            System.out.println("======================================================================");
            System.out.println("Data pemasok masih kosong!                                            ");
            System.out.println("======================================================================");
            return;
        }
            
            System.out.println("======================================================================");
            System.out.println("                     DAFTAR PEMASOK                                   ");
            System.out.println("======================================================================");
            
        for (Pemasok p : daftarPemasok) {
            
            System.out.println("ID Pemasok: " + p.getIdPemasok());
            System.out.println("Nama Pemasok: " + p.getNama());
            System.out.println("No Telepon: " + p.getNoTelepon());
            System.out.println("Alamat Pemasok: " + p.getAlamat());
        }
    }
    public void hapusPemasok(){
        System.out.print("Masukkan ID pemasok: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        boolean ditemukan = false;
        
        for(int i = 0; i < daftarPemasok.size(); i++){
            if(daftarPemasok.get(i).getIdPemasok() == idTarget){    
                daftarPemasok.remove(i);
                System.out.println("=================================================================");
                System.out.println(">> Pemasok berhasil dihapus!                                     ");
                System.out.println("=================================================================");
                
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("=====================================================================");
            System.out.println("ID pemasok tidak ditemukan.                                          ");
            System.out.println("=====================================================================");
        }
    }
    public void updatePemasok(){
        System.out.print("Masukkan ID Pemasok: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Pemasok P : daftarPemasok){
            if(P.getIdPemasok() == idTarget){
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine(); 
                
                System.out.print("Masukkan no telepon: ");
                String noTelepon = scanner.nextLine(); 
                
                System.out.print("Masukkan alamat: ");
                String alamat = scanner.nextLine(); 
                
                if (nama.trim().isEmpty()
                        || noTelepon.trim().isEmpty()
                        || alamat.trim().isEmpty()) {
                    System.out.println("==============================================================");
                    System.out.println("Data tidak boleh kosong.                                      ");
                    System.out.println("==============================================================");
                    return;
                }
                
                P.setNama(nama);
                P.setNoTelepon(noTelepon);
                P.setAlamat(alamat);
                
                System.out.println("==================================================================");
                System.out.println(">> Data pemasok berhasil diperbarui!                              ");
                System.out.println("==================================================================");
                return;
                
            }
        }
        System.out.println("==========================================================================");
        System.out.println("ID pemasok tidak ditemukan.                                               ");
        System.out.println("==========================================================================");
    }
    public void menuPengadaan() {

    boolean kembali = false;

    while (!kembali) {

        System.out.println("==========================================================================");
        System.out.println("                                 KELOLA DATA PENGADAAN                    ");
        System.out.println("==========================================================================");
        System.out.println("1. Tambah Pengadaan                                                       ");
        System.out.println("2. Tampilkan Pengadaan                                                    ");
        System.out.println("3. Hapus Pengadaan                                                        ");
        System.out.println("4. Update Pengadaan                                                       ");
        System.out.println("5. Kembali                                                                ");
        System.out.println("==========================================================================");
        System.out.print("Pilih menu:                                                                 ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1 -> tambahPengadaan();
            case 2 -> tampilkanPengadaan();
            case 3 -> hapusPengadaan();
            case 4 -> updatePengadaan();
            case 5 -> kembali = true;
            default -> System.out.println("Pilihan tidak valid!");
        }
    }
}
    public void tambahPengadaan(){
        System.out.print("ID Pengadaan: "); 
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tanggal (DD/MM/YYYY): "); 
        String tanggal = scanner.nextLine();

        System.out.print("Alamat: "); 
        String alamat = scanner.nextLine();
        
        if (id <= 0
                || tanggal.trim().isEmpty()
                || alamat.trim().isEmpty()) {
            
            System.out.println("==================================================================");
            System.out.println("Data pengadaan tidak valid.                                       ");
            System.out.println("==================================================================");
            return;
        }

        Pengadaan pengadaanBaru = new Pengadaan(id,tanggal,alamat);

        daftarPengadaan.add(pengadaanBaru);

        System.out.println("======================================================================");
        System.out.println(">> Pengadaan baru berhasil ditambahkan!                               ");
        System.out.println("======================================================================");
    }
    
    public void tampilkanPengadaan(){
         if (daftarPengadaan.isEmpty()) {
            System.out.println("==================================================================");
            System.out.println("Data pengadaan masih kosong!                                      ");
            System.out.println("==================================================================");
            return;
        }
        
            System.out.println("==================================================================");
            System.out.println("                              DAFTAR PENGADAAN                    ");
            System.out.println("==================================================================");
            
        for (Pengadaan P : daftarPengadaan) {
            System.out.println("ID Pengadaan: " + P.getIdPengadaan());
            System.out.println("Tanggal Pengadaan: " + P.getTanggal());
            System.out.println("Alamat Pengadaan: " + P.getAlamat());
        } 
    }
    public void hapusPengadaan(){
        System.out.print("Masukkan ID pengadaan: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();
        
        boolean ditemukan = false;
        
        for(int i = 0; i < daftarPengadaan.size(); i++){
            if(daftarPengadaan.get(i).getIdPengadaan() == idTarget){    
                daftarPengadaan.remove(i);
                System.out.println("==============================================================");
                System.out.println(">> Pengadaan berhasil dihapus!                                ");
                 System.out.println("=============================================================");
                 
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("=================================================================");
            System.out.println(">>ID pengadaan tidak ditemukan                                   ");
            System.out.println("=================================================================");
        }
    }
    public void updatePengadaan(){
        System.out.print("Masukkan ID Pengadaan: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (Pengadaan P : daftarPengadaan){
            if(P.getIdPengadaan() == idTarget){
                
                System.out.print("Masukkan tanggal baru: ");
                String tanggal = scanner.nextLine(); 
                
                System.out.print("Masukkan alamat baru: ");
                String alamat = scanner.nextLine(); 
                
                if (tanggal.trim().isEmpty()
                        || alamat.trim().isEmpty()) {
                    
                    System.out.println("=========================================================");
                    System.out.println("Data tidak boleh kosong.                                 ");
                    System.out.println("=========================================================");
                    return;
                }
                
                P.setTanggal(tanggal);
                P.setAlamat(alamat);
                
                System.out.println("=============================================================");
                System.out.println(">> Data pengadaan berhasil diperbarui!                       ");
                System.out.println("=============================================================");
                return;
                
            }
        }
        System.out.println("======================================================================");
        System.out.println(">> ID Pengadaan tidak ditemukan!                                      ");
        System.out.println("======================================================================");
    }
    
}

