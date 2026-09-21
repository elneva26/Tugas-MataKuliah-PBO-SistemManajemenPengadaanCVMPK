
# Sistem manajemen pengedaan CV Mandiri Prima Kreatif
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
Kelas Barang merupakan superclass (kelas induk) yang menjadi dasar bagi jenis-jenis barang dalam sistem. Kelas ini memiliki atribut umum yang dimiliki oleh semua barang, yaitu idBarang, nama, dan stok.
Kelas Barang juga menyediakan method seperti getIdBarang(), getNama(), getStok(), setStok(), dan tampilkanInfo(). Karena atribut umum diletakkan di superclass, subclass tidak perlu mendefinisikan ulang atribut tersebut.

2. Kelas BarangElektronik sebagai subclass
BarangElektronik merupakan subclass dari Barang. Kelas ini mewarisi atribut dan method yang terdapat pada Barang, kemudian memiliki atribut tambahan yaitu garansi.
Kelas ini juga melakukan method overriding pada tampilkanInfo(), sehingga informasi yang ditampilkan dapat disesuaikan dengan karakteristik barang elektronik, termasuk informasi garansi.

3. Kelas BarangNonElektronik sebagai subclass
BarangNonElektronik juga merupakan subclass dari Barang. Kelas ini mewarisi atribut dan method dari Barang, tetapi memiliki atribut tambahan berupa kategori.
Sama seperti BarangElektronik, kelas ini melakukan overriding terhadap method tampilkanInfo() untuk menampilkan informasi khusus barang non-elektronik.


