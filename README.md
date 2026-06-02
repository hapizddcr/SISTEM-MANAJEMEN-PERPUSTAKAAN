# SISTEM MANAJEMEN PERPUSTAKAAN

## Deskripsi

Sistem Manajemen Perpustakaan adalah aplikasi desktop berbasis Java yang digunakan untuk mengelola data perpustakaan secara digital. Aplikasi ini menyediakan fitur pengelolaan buku, pengguna, peminjaman, pengembalian, favorit buku, dan pembuatan bukti transaksi dalam format PDF.

## Teknologi yang Digunakan

* Java
* Java Swing (JFrame & JPanel)
* NetBeans IDE
* MySQL Database
* JDBC (Java Database Connectivity)
* BCrypt Password Hashing
* iTextPDF

## Fitur Aplikasi

### Admin

* Login Admin
* Dashboard Admin
* Kelola Data Buku (Tambah, Edit, Hapus, Cari)
* Kelola Data User
* Melihat Data Peminjaman
* Memproses Pengembalian Buku
* Melihat Riwayat Pengembalian
* Cetak Bukti Peminjaman PDF
* Cetak Bukti Pengembalian PDF

### User

* Register
* Login
* Dashboard User
* Melihat Daftar Buku
* Peminjaman Buku
* Menambahkan Buku ke Favorit
* Melihat Daftar Favorit
* Mengelola Profil Akun

## Struktur Database

### users

Menyimpan data pengguna aplikasi.

Field utama:

* id
* username
* password
* role
* nama_lengkap
* email
* no_hp
* alamat
* status
* created-at

### buku

Menyimpan data buku perpustakaan.

Field utama:

* id
* judul
* pengarang
* penerbit
* tahun
* stok
* created_at

### peminjaman

Menyimpan data transaksi peminjaman dan pengembalian.

Field utama:

* id
* user_id
* tanggal_pinjam
* tanggal_kembali
* tanggal_kembali_aktual
* status
* denda
* created_at
* diproses_oleh

### detail_peminjaman

Menyimpan detail buku yang dipinjam.

Field utama:

* id
* peminjaman_id
* buku_id
* jumlah

### favorit

Menyimpan daftar buku favorit pengguna.

Field utama:

* id
* user_id
* buku_id
* created_at

## Alur Sistem

1. User melakukan registrasi akun.
2. User login ke sistem.
3. User melihat daftar buku.
4. User melakukan peminjaman buku.
5. Stok buku berkurang otomatis.
6. Admin memproses pengembalian buku.
7. Status peminjaman berubah menjadi "dikembalikan".
8. Stok buku bertambah otomatis.
9. Admin bisa mencetak bukti transaksi PDF.

## Keamanan Sistem

* Password disimpan menggunakan BCrypt Hashing.
* Menggunakan Session Login.
* Hak akses dibedakan berdasarkan role Admin dan User.
* Menggunakan PreparedStatement untuk mencegah SQL Injection.

# Struktur Project
```
src/
│
├── admin/
│   ├── PanelBukuAdmin.java
│   ├── PanelDashboardAdmin.java
│   ├── PanelPeminjamanAdmin.java
│   ├── PanelPengembalian.java
│   └── PanelUser.java
│
├── auth/
│   ├── Login.java
│   └── Register.java
│
├── config/
│   ├── Koneksi.java
│   └── database.properties
│
├── dashboard/
│   ├── DashboardAdmin.java
│   └── DashboardUser.java
│
├── Main/
│   └── Main.java
│
├── session/
│   └── Session.java
│
└── user/
    ├── PanelBukuUser.java
    ├── PanelDashboardUser.java
    ├── PanelFavorit.java
    ├── PanelPeminjamanUser.java
    └── PanelProfil.java
```
# Keterangan Package
* admin : Berisi panel yang digunakan oleh admin untuk mengelola data buku, user, peminjaman, dan pengembalian.
* auth : Berisi form login dan registrasi pengguna.
* config : Berisi konfigurasi database dan koneksi MySQL.
* dashboard : Berisi tampilan utama untuk admin dan user setelah login.
* Main : Berisi class utama untuk menjalankan aplikasi.
* session : Berisi class Session untuk menyimpan data pengguna yang sedang login.
* user : Berisi panel yang digunakan oleh user seperti melihat buku, peminjaman, favorit, dan profil.


## Cara Menjalankan Program

1. Import database MySQL.
2. Sesuaikan konfigurasi database pada class Koneksi.
3. Tambahkan library:

   * mysql-connector-j
   * jBCrypt
   * iTextPDF
4. Jalankan project melalui NetBeans.
5. Login menggunakan akun yang tersedia atau lakukan registrasi.

## Pengembang

Kelompok Sistem Manajemen Perpustakaan

* SANDI PERDANA
* HAPIZD NURYADIN
* MUHAMAD ALFIN MUTAQIN
* DINDA
* WANDA

## Akun Demo

### Admin

Username : admin

Password : admin12345

### User

Username : user

Password : user12345
