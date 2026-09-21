
# Sistem manajemen pengadaan CV Mandiri Prima Kreatif
## Nama : Elena Dementieva
## NIM : 2509116008
## Kelas : Sistem Informasi A'25
## Matkul : Pemrograman Berorientasi Objek (PBO)


### Penjelasan studi kasus:
Program ini berfokus pada pengelolaan data barang, data pemasok, dan data pengadaan. Pengelolaan data barang digunakan untuk mencatat informasi barang yang tersedia atau dibutuhkan dalam proses pengadaan. Data pemasok digunakan untuk menyimpan informasi pihak yang menyediakan barang, sedangkan data pengadaan digunakan untuk mencatat proses pengadaan barang yang dilakukan oleh perusahaan.


Program menerapkan konsep CRUD (Create, Read, Update, Delete), sehingga pengguna dapat menambahkan, menampilkan, memperbarui, dan menghapus data. Dengan adanya program ini, pengelolaan data diharapkan menjadi lebih terstruktur dan memudahkan pengguna dalam melakukan pencatatan serta pemantauan informasi pengadaan barang.


Program ini dikembangkan dengan menerapkan konsep Pemrograman Berorientasi Objek (PBO), meliputi class, object, constructor, access modifier, encapsulation, ArrayList, percabangan, input pengguna, perulangan, dan validasi input.


Program terdiri dari satu class entry point, yaitu SistemmanajemenCVMPK, serta empat class pendukung, yaitu Service, Barang, Pemasok, dan Pengadaan. Setiap class memiliki peran masing-masing dalam mendukung pengelolaan data dan menjalankan fungsi sistem.


Dengan demikian, program ini diharapkan dapat menjadi solusi sederhana untuk membantu pengelolaan data barang, pemasok, dan pengadaan pada CV Mandiri Prima Kreatif secara lebih sistematis.


### Penjelasan hierarki class:

Barang menjadi kelas induk yang menyimpan karakteristik umum seluruh barang. BarangElektronik dan BarangNonElektronik menjadi kelas turunan yang mewarisi karakteristik tersebut dan menambahkan karakteristik khusus masing-masing. Selain inheritance, kedua subclass juga menerapkan polymorphism melalui overriding method tampilkanInfo().

1. Kelas Barang sebagai superclass
   
Kelas Barang merupakan superclass (kelas induk) yang menjadi dasar bagi jenis-jenis barang dalam sistem. Kelas ini memiliki atribut umum yang dimiliki oleh semua barang, yaitu idBarang, nama, dan stok. Kelas Barang juga menyediakan method seperti getIdBarang(), getNama(), getStok(), setStok(), dan tampilkanInfo(). Karena atribut umum diletakkan di superclass, subclass tidak perlu mendefinisikan ulang atribut tersebut.

3. Kelas BarangElektronik sebagai subclass
   
BarangElektronik merupakan subclass dari Barang. Kelas ini mewarisi atribut dan method yang terdapat pada Barang, kemudian memiliki atribut tambahan yaitu garansi. Kelas ini juga melakukan method overriding pada tampilkanInfo(), sehingga informasi yang ditampilkan dapat disesuaikan dengan karakteristik barang elektronik, termasuk informasi garansi.

5. Kelas BarangNonElektronik sebagai subclass
   
BarangNonElektronik juga merupakan subclass dari Barang. Kelas ini mewarisi atribut dan method dari Barang, tetapi memiliki atribut tambahan berupa kategori.
Sama seperti BarangElektronik, kelas ini melakukan overriding terhadap method tampilkanInfo() untuk menampilkan informasi khusus barang non-elektronik.


### Penjelasan inheritance

Penerapan inheritance (pewarisan) pada program terdapat pada kelas BarangElektronik dan BarangNonElektronik yang mewarisi kelas Barang sebagai superclass. Inheritance digunakan agar atribut dan method yang bersifat umum pada barang dapat digunakan kembali oleh kelas turunannya.

1. Superclass Barang
   
Kelas Barang berperan sebagai kelas induk (superclass) yang menyimpan atribut umum yang dimiliki oleh setiap barang, yaitu:

<img width="425" height="157" alt="image" src="https://github.com/user-attachments/assets/ba500220-9b68-4581-85da-37ebef045ec5" />

2. Subclass BarangElektronik
   
Inheritance diterapkan pada deklarasi:

<img width="595" height="50" alt="image" src="https://github.com/user-attachments/assets/953486ac-5524-4141-876e-15dd96d3cbdf" />

Dengan adanya extends maka menunjukkan bahwa BarangElektronik merupakan subclass dari Barang. Dengan demikian, BarangElektronik mewarisi karakteristik dan method dari kelas Barang.


3. Subclass BarangNonElektronik
   
Inheritance juga diterapkan pada kelas BarangNonElektronik melalui:

<img width="309" height="23" alt="image" src="https://github.com/user-attachments/assets/a4ec2a19-3120-446c-8742-e94f6db86dc0" />

Dengan menggunakan penerapan inheritance ini, kedua subclass tidak perlu membuat ulang atribut idBarang, nama, dan stok karena atribut tersebut sudah disediakan oleh superclass Barang. Hal ini membuat struktur program lebih terorganisir dan mengurangi pengulangan kode.


Inheritance pada program diterapkan dengan menjadikan kelas Barang sebagai superclass dan kelas BarangElektronik serta BarangNonElektronik sebagai subclass. Kedua subclass menggunakan kata kunci extends untuk mewarisi atribut dan method dari kelas Barang. Constructor subclass menggunakan super() untuk memanggil constructor superclass, sedangkan atribut garansi dan kategori digunakan sebagai karakteristik khusus masing-masing subclass. Selain inheritance, program juga menerapkan method overriding melalui method tampilkanInfo() yang ditulis ulang pada kedua subclass.

-> Tampilan Utama

<img width="829" height="256" alt="image" src="https://github.com/user-attachments/assets/2e7cb145-6366-42f0-b4c7-bb9a74191e9b" />


-> Menu Kelola Barang

<img width="975" height="326" alt="image" src="https://github.com/user-attachments/assets/e9a98bef-ccc5-4c37-992f-b2af89a2c893" />


-> Tambah Data Barang

<img width="869" height="430" alt="image" src="https://github.com/user-attachments/assets/b615c6a4-6e7f-4929-98c1-b7e98dc633bf" />

-> Tampilkan Barang

<img width="848" height="775" alt="image" src="https://github.com/user-attachments/assets/a72ff4a6-d25c-43ac-98f5-0980cea6f58e" />

-> Update Stok

<img width="885" height="192" alt="image" src="https://github.com/user-attachments/assets/8c4cf877-0db5-42be-8dfd-03f1df690e5b" />

-> Hapus Barang

<img width="873" height="153" alt="image" src="https://github.com/user-attachments/assets/d407c59d-c9bc-4bd3-8aac-e3878a2bf4fd" />

-> Kembali

<img width="907" height="317" alt="image" src="https://github.com/user-attachments/assets/453a5f41-68d7-425b-bc32-00efc12b8fc2" />

ketika memilih angka 5, maka sistem akan otomatis kembali ke menu utama.

-> Menu Kelola Pemasok

<img width="967" height="289" alt="image" src="https://github.com/user-attachments/assets/25007af1-b194-482b-949f-f092cd9637e0" />

-> Tambah Pemasok

<img width="959" height="364" alt="image" src="https://github.com/user-attachments/assets/6e789291-fed9-47ab-b16b-b347bcfcb153" />

-> Tampilkan Pemasok

<img width="888" height="334" alt="image" src="https://github.com/user-attachments/assets/46970778-8180-4acd-975b-41b7f21a41fb" />

-> Update Pemasok

<img width="832" height="247" alt="image" src="https://github.com/user-attachments/assets/eeae0271-770d-4857-8023-544a86453a30" />

-> Hapus Pemasok

<img width="813" height="148" alt="image" src="https://github.com/user-attachments/assets/0f354b65-c063-473f-add1-da0690ae0340" />

-> Kembali

<img width="831" height="303" alt="image" src="https://github.com/user-attachments/assets/b0771246-194a-4fbd-89e1-6c4f44a54b56" />

ketika memilih angka 5, maka sistem akan otomatis kembali ke menu utama.

-> Menu Pengadaan

<img width="939" height="298" alt="image" src="https://github.com/user-attachments/assets/b6ed5727-2164-4cc8-84a6-1b8ecea2426d" />

->Tambah Pengadaan

<img width="892" height="220" alt="image" src="https://github.com/user-attachments/assets/026986df-9209-4761-b99b-c53550de9d3f" />

-> Tampilkan Pengadaan

<img width="832" height="234" alt="image" src="https://github.com/user-attachments/assets/df825357-7369-4912-b141-0dc20fdd28f2" />

-> Update Pengadaan

<img width="772" height="213" alt="image" src="https://github.com/user-attachments/assets/c8be0720-c2fc-482a-8859-4f4c38eec92a" />

-> Hapus Pengadaan

<img width="772" height="157" alt="image" src="https://github.com/user-attachments/assets/5eb83d5a-5f9d-45e8-9363-a2af9cf1c605" />

-> Kembali

<img width="822" height="304" alt="image" src="https://github.com/user-attachments/assets/0e68a17b-e917-45be-845d-a9ed4f3547ef" />

ketika memilih angka 5, maka sistem akan otomatis kembali ke menu utama.

















