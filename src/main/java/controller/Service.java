/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;
import model.Barang;
import model.BarangElektronik;
import model.Laptop;
import model.BarangNonElektronik;
import model.Pemasok;
import model.Pengadaan;

public class Service {

    private ArrayList<Barang> daftarBarang;
    private ArrayList<Pemasok> daftarPemasok;
    private ArrayList<Pengadaan> daftarPengadaan;

    private Scanner scanner;

    public Service(Scanner scanner) {
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
                new Laptop(
                        2,
                        "Laptop Lenovo",
                        8,
                        "3 Tahun",
                        "Intel Core i5"
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

    public void daftarBarang() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println("====================================================================");
            System.out.println("                      KELOLA DATA BARANG                            ");
            System.out.println("====================================================================");
            System.out.println("1. Tambah Barang                                                    ");
            System.out.println("2. Tampilkan Barang                                                 ");
            System.out.println("3. Hapus Barang                                                     ");
            System.out.println("4. Update Stok                                                      ");
            System.out.println("5. Kembali                                                          ");
            System.out.println("====================================================================");
            System.out.print("Pilih menu:                                                           ");

            String inputPilihan = scanner.nextLine();

            int pilihan;

            try {
                pilihan = Integer.parseInt(inputPilihan.trim());
            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>                Input harus berupa angka!               <<<<<");
                System.out.println("==================================================================");
                continue;
            }

            switch (pilihan) {
                case 1 ->
                    tambahBarang();
                case 2 ->
                    tampilkanBarang();
                case 3 ->
                    hapusBarang();
                case 4 ->
                    updateStok();
                case 5 ->
                    kembali = true;
                default -> {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>                  Pilihan tidak valid!                  <<<<<");
                    System.out.println("==================================================================");
                }
            }
        }
    }

    public void tambahBarang() {

        System.out.println("==================================================================");
        System.out.println("                       TAMBAH DATA BARANG                         ");
        System.out.println("==================================================================");

        int idBarang;

        while (true) {

            System.out.print("ID Barang(0 untuk kembali): ");
            String inputId = scanner.nextLine();

            if (inputId.trim().equals("0")) {
                System.out.println("==================================================================");
                System.out.println(">>>>>           Penambahan barang dibatalkan                 <<<<<");
                System.out.println("==================================================================");
                return;
            }

            if (inputId.trim().isEmpty()) {
                System.out.println("==================================================================");
                System.out.println(">>>>>              ID barang wajib diisi!                    <<<<<");
                System.out.println("==================================================================");
                continue;
            }

            try {
                idBarang = Integer.parseInt(inputId.trim());

                if (idBarang > 0) {
                    break;

                } else {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>         ID barang harus lebih dari nilai 0             <<<<<");
                    System.out.println("==================================================================");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>        ID barang harus diisi dengan angka!             <<<<<");
                System.out.println("==================================================================");
                continue;
            }
        }
        for (Barang b : daftarBarang) {
            if (b.getIdBarang() == idBarang) {
                System.out.println("===============================================================");
                System.out.println(">>>>> ID barang sudah digunakan! Silakan gunakan ID lain  <<<<<");
                System.out.println("===============================================================");
                return;
            }
        }
        String nama;

        while (true) {
            System.out.print("Nama Barang: ");
            nama = scanner.nextLine().trim();

            if (nama.isEmpty()) {
                System.out.println("==================================================================");
                System.out.println(">>>>>           Nama barang tidak boleh kosong!              <<<<<");
                System.out.println("==================================================================");
                continue;
            }
            break;

        }

        int stok;

        while (true) {

            System.out.print("Stok Barang: ");
            String inputStok = scanner.nextLine();

            try {
                stok = Integer.parseInt(inputStok.trim());

                if (stok >= 0) {
                    break;

                } else {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>             Stok tidak boleh kurang dari 0!            <<<<<");
                    System.out.println("==================================================================");
                }

            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>             Stok harus diisi dengan angka!             <<<<<");
                System.out.println("==================================================================");
            }
        }
        int jenis;

        while (true) {
            System.out.println("Jenis Barang:");
            System.out.println("1. Barang Elektronik");
            System.out.println("2. Barang Non-Elektronik");
            System.out.print("Pilih jenis (1-2): ");

            String inputJenis = scanner.nextLine();

            try {
                jenis = Integer.parseInt(inputJenis.trim());

                if (jenis == 1 || jenis == 2) {
                    break;

                } else {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>      Jenis barang hanya boleh memilih 1 atau 2!        <<<<<");
                    System.out.println("==================================================================");
                }

            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>       Jenis barang harus diisi dengan angka!           <<<<<");
                System.out.println("==================================================================");
            }
        }
        Barang barangBaru;

        if (jenis == 1) {

            String garansi;

            while (true) {
            System.out.print("Garansi: ");
            garansi = scanner.nextLine().trim();

            if (garansi.isEmpty()) {
            System.out.println("==================================================================");
            System.out.println(">>>>>      Garansi wajib diisi dan tidak boleh kosong        <<<<<");
            System.out.println("==================================================================");
            continue;
        }

        break;
    }

    int jenisElektronik;

    while (true) {
        System.out.println("Jenis Barang Elektronik:");
        System.out.println("1. Barang Elektronik");
        System.out.println("2. Laptop");
        System.out.print("Pilih jenis (1-2): ");

        String inputElektronik = scanner.nextLine();

        try {
            jenisElektronik = Integer.parseInt(inputElektronik.trim());

            if (jenisElektronik == 1 || jenisElektronik == 2) {
                break;
            } else {
                System.out.println("==================================================================");
                System.out.println(">>>>>       Pilihan hanya boleh 1 atau 2!                   <<<<<");
                System.out.println("==================================================================");
            }

        } catch (NumberFormatException e) {
            System.out.println("==================================================================");
            System.out.println(">>>>>       Pilihan harus berupa angka!                    <<<<<");
            System.out.println("==================================================================");
        }
    }

    if (jenisElektronik == 1) {

        barangBaru = new BarangElektronik(
                idBarang,
                nama,
                stok,
                garansi
        );

    } else {

        String processor;

        while (true) {
            System.out.print("Processor: ");
            processor = scanner.nextLine().trim();

            if (processor.isEmpty()) {
                System.out.println("==================================================================");
                System.out.println(">>>>>       Processor wajib diisi dan tidak boleh kosong!    <<<<<");
                System.out.println("==================================================================");
                continue;
            }

            break;
        }

        barangBaru = new Laptop(
                idBarang,
                nama,
                stok,
                garansi,
                processor
        );
    }

        } else if (jenis == 2) {

            String kategori;

            while (true) {
                System.out.println("kategori: ");
                kategori = scanner.nextLine().trim();

                if (kategori.isEmpty()) {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>              Kategori tidak boleh kosong!              <<<<<");
                    System.out.println("==================================================================");
                    continue;
                }

                break;
            }

            barangBaru = new BarangNonElektronik(
                    idBarang,
                    nama,
                    stok,
                    kategori
            );

        } else {
            System.out.println("=====================================================================");
            System.out.println(">>>>>   Jenis barang tidak tersedia! mohon data dicek kembali   <<<<<");
            System.out.println("=====================================================================");
            return;
        }

        daftarBarang.add(barangBaru);

        System.out.println("===================================================================");
        System.out.println(">>>>>              Barang baru berhasil ditambahkan!          <<<<<");
        System.out.println("===================================================================");
    }

    public void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("=========================================================================");
            System.out.println(">>>>>                    Data barang masih kosong!                  <<<<<");
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
        System.out.println(">>>>>                  DATA SELESAI DITAMPILKAN              <<<<<");
        System.out.println("==================================================================");
    }

    public void hapusBarang() {
        
        int idBarang;
        
        while (true) {
            System.out.print("Masukkan ID Barang: ");
            String inputId = scanner.nextLine();
            
            if (inputId.trim().isEmpty()){
                System.out.println("===========================================================");
                System.out.println(">>>>>               ID barang wajib  diisi!           <<<<<");
                System.out.println("===========================================================");
                continue;
            }
        
        try {
            idBarang = Integer.parseInt(inputId.trim());
            
            if (idBarang > 0) {
                break;
                
            } else {
                System.out.println("===========================================================");
                System.out.println(">>>>>      ID barang harus lebih dari nilai 0         <<<<<");
                System.out.println("===========================================================");
            }
        } catch (NumberFormatException e) {
            System.out.println("===========================================================");
            System.out.println(">>>>>          ID barang harus berupa angka!          <<<<<");
            System.out.println("===========================================================");
           
        }
    }

        boolean ditemukan = false;

        for (int i = 0; i < daftarBarang.size(); i++) {
            if (daftarBarang.get(i).getIdBarang() == idBarang) {
                daftarBarang.remove(i);
                System.out.println("==================================================================");
                System.out.println(">>>>>              Barang berhasil dihapus!                  <<<<<");
                System.out.println("==================================================================");

                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("======================================================================");
            System.out.println(">>>>>               ID barang tidak ditemukan -_- ...            <<<<<");
            System.out.println("======================================================================");
        }
    }

    public void updateStok() {
        
        int idBarang;
        
        while (true) {
            System.out.print("Masukkan ID Barang: ");
            String inputId = scanner.nextLine();
            
            if (inputId.trim().isEmpty()) {
                System.out.println("=======================================================================");
                System.out.println(">>>>>                     ID barang wajib diisi!                  <<<<<");
                System.out.println("=======================================================================");
                continue;
                
            }
    
            try {
                idBarang = Integer.parseInt(inputId.trim());
                
                if (idBarang <= 0) {
                    System.out.println("=======================================================================");
                    System.out.println(">>>>>                 ID barang harus lebih dari 0!               <<<<<");
                    System.out.println("=======================================================================");
                    continue;
                }
                break;
                
            } catch (NumberFormatException e) {
                System.out.println("=======================================================================");
                System.out.println(">>>>>                ID barang harus berupa angka!                <<<<<");
                System.out.println("=======================================================================");
           
            }
        }

        for (Barang b : daftarBarang) {
            if (b.getIdBarang() == idBarang) {

                int stokBaru;
                
                while (true) {
                    System.out.println("Stok Baru: ");
                    String inputStok = scanner.nextLine();
                    
                    if (inputStok.trim().isEmpty()) {
                        System.out.println("=======================================================================");
                        System.out.println(">>>>>                        Stok wajib diisi!                    <<<<<");
                        System.out.println("=======================================================================");
                        continue;
                    }

                        try {
                            stokBaru = Integer.parseInt(inputStok.trim());
                            
                            if (stokBaru < 0) {
                                System.out.println("=======================================================================");
                                System.out.println(">>>>>            Stok tidak boleh kurang dari o!                  <<<<<");
                                System.out.println("=======================================================================");
                                continue;
                            }
                            break;
                            
                    } catch (NumberFormatException e) {
                        System.out.println("==============================================================");
                        System.out.println(">>>>>            Stok harus berupa angka!                <<<<<");
                        System.out.println("==============================================================");
                    }
                }

                b.setStok(stokBaru);
                
                System.out.println("==================================================================");
                System.out.println(">>>>>         Stok barang berhasil diperbarui :)             <<<<<");
                System.out.println("==================================================================");
                return;
            }
        }
        System.out.println("==========================================================================");
        System.out.println(">>>>>                ID barang tidak ditemukan -_- ...               <<<<<");
        System.out.println("==========================================================================");
    }

    public void daftarPemasok() {

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

            String inputPilihan = scanner.nextLine();

            int pilihan;

            try {
                pilihan = Integer.parseInt(inputPilihan.trim());
            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>                Input harus berupa angka!               <<<<<");
                System.out.println("==================================================================");
                continue;
            }

            switch (pilihan) {
                case 1 ->
                    tambahPemasok();
                case 2 ->
                    tampilkanPemasok();
                case 3 ->
                    hapusPemasok();
                case 4 ->
                    updatePemasok();
                case 5 ->
                    kembali = true;
                default -> {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>                 Pilihan tidak valid!                   <<<<<");
                    System.out.println("==================================================================");
                }
            }
        }
    }

    public void tambahPemasok() {
        System.out.println("============================================================================");
        System.out.println("                               TAMBAH PEMASOK                               ");
        System.out.println("============================================================================");

        int idPemasok;

        while (true) {
            System.out.print("ID Pemasok: ");
            String inputId = scanner.nextLine();

            if (inputId.trim().isEmpty()) {
                System.out.println("============================================================================");
                System.out.println(">>>>>                        ID pemasok wajib diisi!                   <<<<<");
                System.out.println("============================================================================");
                continue;
            }
            try {
                idPemasok = Integer.parseInt(inputId.trim());

                if (idPemasok <= 0) {
                    System.out.println("============================================================================");
                    System.out.println(">>>>>                  ID pemasok harus lebih dari 0!                  <<<<<");
                    System.out.println("============================================================================");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("============================================================================");
                System.out.println(">>>>>                  ID pemasok harus diisi dengan angka!            <<<<<");
                System.out.println("============================================================================");
            }
        }

        String nama;
        for (Pemasok p : daftarPemasok) {
            if (p.getIdPemasok() == idPemasok) {
                System.out.println("=============================================================================");
                System.out.println(">>>>>       ID pemasok sudah digunakan! Silakan gunakan ID lain.        <<<<<");
                System.out.println("=============================================================================");
                return;
            }
        }
        do {
            System.out.println("Nama Pemasok");
            nama = scanner.nextLine();

            if (nama.trim().isEmpty()) {
                System.out.println("=============================================================================");
                System.out.println(">>>>>                       Nama pemasok wajib diisi!                   <<<<<");
                System.out.println("=============================================================================");
            }
        } while (nama.trim().isEmpty());

        String alamat;

        do {
            System.out.print("Alamat Pemasok: ");
            alamat = scanner.nextLine();

            if (alamat.trim().isEmpty()) {
                System.out.println("=============================================================================");
                System.out.println(">>>>>                      Alamat pemasok wajib diisi!                  <<<<<");
                System.out.println("=============================================================================");
            }
        } while (alamat.trim().isEmpty());

        String noTelepon;

        while (true) {
            System.out.print("No Telepon: ");
            noTelepon = scanner.nextLine();

            if (noTelepon.trim().isEmpty()) {
                System.out.println("==============================================================================");
                System.out.println(">>>>>                       No telepon wajib diisi!                      <<<<<");
                System.out.println("==============================================================================");
                continue;
            }

            if (!noTelepon.matches("\\d+")) {
                System.out.println("==============================================================================");
                System.out.println(">>>>>                  No telepon hanya boleh berisi angka!              <<<<<");
                System.out.println("==============================================================================");
                continue;
            }
            break;
        }
        daftarPemasok.add(new Pemasok(idPemasok, nama, alamat, noTelepon));

        System.out.println("==========================================================================");
        System.out.println(">>>>>                 Pemasok baru berhasil ditambahkan!             <<<<<");
        System.out.println("==========================================================================");
    }

    public void tampilkanPemasok() {
        if (daftarPemasok.isEmpty()) {
            System.out.println("======================================================================");
            System.out.println(">>>>>                Data pemasok masih kosong!                  <<<<<");
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

    public void hapusPemasok() {
        
        int idPemasok;
        
        while (true) {
            System.out.print("Masukkan ID pemasok: ");
            String inputId = scanner.nextLine();
            
            if (inputId.trim().isEmpty()) {
                System.out.println("=================================================================");
                System.out.println(">>>>>                 ID Pemasok wajib diisi!               <<<<<");
                System.out.println("=================================================================");
                continue;
        }

        try {
            idPemasok = Integer.parseInt(inputId.trim());
            
            if (idPemasok > 0) {
                break;
          
            }else {
                System.out.println("=================================================================");
                System.out.println(">>>>>              ID pemasok harus lebih dari 0!           <<<<<");
                System.out.println("=================================================================");
            }
        } catch (NumberFormatException e) {
            System.out.println("=================================================================");
            System.out.println(">>>>>              ID pemasok harus berupa angka!           <<<<<");
            System.out.println("=================================================================");
        }
    }

    boolean ditemukan = false;

        for (int i = 0; i < daftarPemasok.size(); i++) {
            if (daftarPemasok.get(i).getIdPemasok() == idPemasok) {
                daftarPemasok.remove(i);

                System.out.println("=================================================================");
                System.out.println(">>>>>             Pemasok berhasil dihapus!                 <<<<<");
                System.out.println("=================================================================");

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("=====================================================================");
            System.out.println(">>>>>              ID pemasok tidak ditemukan -_- ...           <<<<<");
            System.out.println("=====================================================================");
        }
    }

    public void updatePemasok() {
        System.out.print("Masukkan ID Pemasok: ");
        String inputId = scanner.nextLine();

        int idTarget;

        try {
            idTarget = Integer.parseInt(inputId.trim());
        } catch (NumberFormatException e) {
            System.out.println("==================================================================");
            System.out.println(">>>>>                 ID pemasok harus berupa angka!         <<<<<");
            System.out.println("==================================================================");
            return;
        }

        for (Pemasok p : daftarPemasok) {
            if (p.getIdPemasok() == idTarget) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();

                System.out.print("Masukkan no telepon: ");
                String noTelepon = scanner.nextLine();

                System.out.print("Masukkan alamat: ");
                String alamat = scanner.nextLine();

                if (nama.trim().isEmpty()
                        || noTelepon.trim().isEmpty()
                        || alamat.trim().isEmpty()
                        || !noTelepon.matches("\\d+")) {

                    System.out.println("========================================================================");
                    System.out.println("Data tidak valid! Pastikan semua data terisi dan no telepon hanya angka ");
                    System.out.println("========================================================================");
                    return;
                }

                p.setNama(nama);
                p.setNoTelepon(noTelepon);
                p.setAlamat(alamat);

                System.out.println("==================================================================");
                System.out.println(">>>>>           Data pemasok berhasil diperbarui!            <<<<<");
                System.out.println("==================================================================");
                return;

            }
        }
        System.out.println("==========================================================================");
        System.out.println(">>>>>               ID pemasok tidak ditemukan -_- ...               <<<<<");
        System.out.println("==========================================================================");
    }

    public void daftarPengadaan() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println("==========================================================================");
            System.out.println("                             KELOLA DATA PENGADAAN                        ");
            System.out.println("==========================================================================");
            System.out.println("1. Tambah Pengadaan                                                       ");
            System.out.println("2. Tampilkan Pengadaan                                                    ");
            System.out.println("3. Hapus Pengadaan                                                        ");
            System.out.println("4. Update Pengadaan                                                       ");
            System.out.println("5. Kembali                                                                ");
            System.out.println("==========================================================================");
            System.out.print("Pilih menu:                                                                 ");

            String inputPilihan = scanner.nextLine();

            int pilihan;

            try {
                pilihan = Integer.parseInt(inputPilihan.trim());
            } catch (NumberFormatException e) {
                System.out.println("==================================================================");
                System.out.println(">>>>>                Input harus berupa angka!               <<<<<");
                System.out.println("==================================================================");
                continue;
            }

            switch (pilihan) {
                case 1 ->
                    tambahPengadaan();
                case 2 ->
                    tampilkanPengadaan();
                case 3 ->
                    hapusPengadaan();
                case 4 ->
                    updatePengadaan();
                case 5 ->
                    kembali = true;
                default -> {
                    System.out.println("==================================================================");
                    System.out.println(">>>>>                Pilihan tidak valid!                    <<<<<");
                    System.out.println("==================================================================");
                }
            }
        }
    }

    public void tambahPengadaan() {

        System.out.println("=====================================================================");
        System.out.println("                            TAMBAH PENGADAAN                         ");
        System.out.println("=====================================================================");

        int id;

        while (true) {

            System.out.print("ID Pengadaan: ");
            String inputId = scanner.nextLine();

            if (inputId.trim().isEmpty()) {
                System.out.println("====================================================================");
                System.out.println(">>>>>                  ID pengadaan wajib diisi!               <<<<<");
                System.out.println("====================================================================");
                continue;
            }

            try {
                id = Integer.parseInt(inputId.trim());

                if (id <= 0) {
                    System.out.println("====================================================================");
                    System.out.println(">>>>>            ID pengadaan harus lebih dari 0!              <<<<<");
                    System.out.println("====================================================================");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("====================================================================");
                System.out.println(">>>>>              ID pengadaan harus berupa angka!            <<<<<");
                System.out.println("====================================================================");
            }
        }

        for (Pengadaan p : daftarPengadaan) {
            if (p.getIdPengadaan() == id) {
                System.out.println("====================================================================");
                System.out.println(">>>>>   ID pengadaan sudah digunakan! Silakan gunakan ID lain  <<<<<");
                System.out.println("====================================================================");
                return;
            }
        }

        String tanggal;

        while (true) {

            System.out.print("Tanggal (DD/MM/YYYY): ");
            tanggal = scanner.nextLine().trim();

            if (tanggal.isEmpty()) {
                System.out.println("======================================================================");
                System.out.println(">>>>>                Tanggal pengadaan wajib diisi!              <<<<<");
                System.out.println("======================================================================");
                continue;
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter
                        .ofPattern("dd/MM/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

                LocalDate.parse(tanggal, formatter);

                break;

            } catch (DateTimeParseException e) {
                System.out.println("======================================================================");
                System.out.println(">>>>>      Format tanggal harus DD/MM/YYYY dan harus valid!      <<<<<");
                System.out.println("======================================================================");
            }
        }

        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();

        if (alamat.trim().isEmpty()) {
            System.out.println("======================================================================");
            System.out.println(">>>>>                Alamat pengadaan wajib diisi!               <<<<<");
            System.out.println("======================================================================");
            return;
        }

        Pengadaan pengadaanBaru = new Pengadaan(id, tanggal, alamat);

        daftarPengadaan.add(pengadaanBaru);

        System.out.println("======================================================================");
        System.out.println(">>>>>            Pengadaan baru berhasil ditambahkan!            <<<<<");
        System.out.println("======================================================================");
    }

    public void tampilkanPengadaan() {
        if (daftarPengadaan.isEmpty()) {
            System.out.println("==================================================================");
            System.out.println(">>>>>              Data pengadaan masih kosong!              <<<<<");
            System.out.println("==================================================================");
            return;
        }

        System.out.println("==================================================================");
        System.out.println("                          DAFTAR PENGADAAN                        ");
        System.out.println("==================================================================");

        for (Pengadaan P : daftarPengadaan) {
            System.out.println("ID Pengadaan: " + P.getIdPengadaan());
            System.out.println("Tanggal Pengadaan: " + P.getTanggal());
            System.out.println("Alamat Pengadaan: " + P.getAlamat());
        }
    }

    public void hapusPengadaan() {
        System.out.print("Masukkan ID pengadaan: ");
        String inputId = scanner.nextLine();

        int idTarget;

        try {
            idTarget = Integer.parseInt(inputId.trim());
        } catch (NumberFormatException e) {
            System.out.println("==============================================================");
            System.out.println(">>>>>         ID pengadaan harus berupa angka!           <<<<<");
            System.out.println("==============================================================");
            return;
        }

        boolean ditemukan = false;

        for (int i = 0; i < daftarPengadaan.size(); i++) {
            if (daftarPengadaan.get(i).getIdPengadaan() == idTarget) {
                daftarPengadaan.remove(i);

                System.out.println("==============================================================");
                System.out.println(">>>>>            Pengadaan berhasil dihapus!             <<<<<");
                System.out.println("==============================================================");

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("=================================================================");
            System.out.println(">>>>>        ID pengadaan tidak ditemukan -_- ...           <<<<<");
            System.out.println("=================================================================");
        }
    }

    public void updatePengadaan() {
        System.out.print("Masukkan ID Pengadaan: ");
        String inputId = scanner.nextLine();

        int idTarget;

        try {
            idTarget = Integer.parseInt(inputId.trim());
        } catch (NumberFormatException e) {
            System.out.println("======================================================================");
            System.out.println(">>>>>              ID pengadaan harus berupa angka!              <<<<<");
            System.out.println("======================================================================");
            return;
        }

        for (Pengadaan P : daftarPengadaan) {
            if (P.getIdPengadaan() == idTarget) {

                String tanggal;

                while (true) {
                    System.out.print("Masukkan tanggal baru (DD/MM/YYYY): ");
                    tanggal = scanner.nextLine().trim();

                    if (tanggal.isEmpty()) {
                        System.out.println("=========================================================");
                        System.out.println(">>>>>           Tanggal tidak boleh kosong!         <<<<<");
                        System.out.println("=========================================================");
                        continue;
                    }

                    try {
                        DateTimeFormatter formatter = DateTimeFormatter
                                .ofPattern("dd/MM/uuuu")
                                .withResolverStyle(ResolverStyle.STRICT);

                        LocalDate.parse(tanggal, formatter);

                        break;

                    } catch (DateTimeParseException e) {
                        System.out.println("=============================================================");
                        System.out.println(">>>>>   Format tanggal tidak valid! Gunakan DD/MM/YYYY  <<<<<");
                        System.out.println("=============================================================");
                    }
                }

                System.out.print("Masukkan alamat baru: ");
                String alamat = scanner.nextLine();

                if (alamat.trim().isEmpty()) {
                    System.out.println("=============================================================");
                    System.out.println(">>>>>               Alamat tidak boleh kosong!          <<<<<");
                    System.out.println("=============================================================");
                    return;

                }
                P.setTanggal(tanggal);
                P.setAlamat(alamat);

                System.out.println("======================================================================");
                System.out.println(">>>>>                 Data pengadaan berhasil diperbarui!        <<<<<");
                System.out.println("======================================================================");
                return;
            }
        }
    }
}

