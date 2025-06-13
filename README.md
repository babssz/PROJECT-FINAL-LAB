# Galeri Properti: Aplikasi Manajemen Properti Sederhana

Galeri Properti adalah aplikasi berbasis Java yang memanfaatkan konsep Object-Oriented Programming (OOP) untuk menampilkan informasi berbagai jenis properti, baik properti riil maupun properti virtual.
Pengguna dapat melihat detail setiap properti yang tersedia, mempelajari informasi terkait tipe properti, harga, lokasi, dan deskripsi.

---

## Tujuan Aplikasi

Memberikan kemudahan bagi pengguna dalam:
- Menjelajahi berbagai data properti yang telah tersedia.
- Melihat informasi lengkap mengenai properti.
- Memahami perbedaan antara properti riil dan properti virtual.
- Memberikan pengalaman interaktif untuk pembelajaran dan eksplorasi data properti.

---

## Struktur Kelas

```
├── java\projectfinal
│   ├── Database.java           # Class yang menyimpan data properti (simulasi database lokal)
│   ├── DetailViewController.java  # Mengatur tampilan detail properti
│   ├── Main.java               # Entry point aplikasi (main method)
│   ├── MainViewController.java # Mengatur tampilan utama daftar properti
│   ├── Properti.java           # Kelas abstrak sebagai parent dari semua properti
│   ├── PropertiRiil.java       # Subclass untuk properti riil
│   ├── PropertiVirtual.java    # Subclass untuk properti virtual
├── resources
│   ├── assets/                 # Resource tambahan 
│   ├── DetailView.fxml         # Layout tampilan detail properti
│   └── MainView.fxml           # Layout tampilan utama daftar properti

```

---

## Deskripsi Kelas

### `Properti (abstract)`

Kelas abstrak yang menjadi induk dari semua jenis properti. Memuat atribut dasar seperti:

* ID properti
* Nama
* Lokasi
* Harga

### `PropertiRiil`

Subclass dari `Properti` untuk properti fisik seperti:

* Rumah
* Apartemen
* Tanah
  Menambahkan atribut seperti luas bangunan, jumlah kamar, fasilitas, dll.

### `PropertiVirtual`

Subclass dari `Properti` untuk properti digital seperti:

* NFT
* Domain website
* Aset crypto
  Menambahkan atribut seperti jenis aset, platform, valuasi digital, dll.

### `ProfilFinansial`

Kelas yang menerapkan prinsip **Encapsulation** untuk menyimpan:

* Nama pemilik
* Pendapatan
* Pengeluaran
* Total aset
  Data hanya bisa diakses atau dimodifikasi melalui getter dan setter yang aman.

### `AplikasiUtama`

Kelas utama yang menangani:

* Input data properti
* Pengelolaan data properti
* Menampilkan informasi properti yang dimiliki

### `PrimaryController` & `SecondaryController`

Kelas opsional sebagai pengatur alur jika arsitektur modular/MVC digunakan.

---

## Cara Menjalankan Program

1. **Pastikan sudah menginstall:**
    - JDK (versi minimal: Java 17 atau sesuai kebutuhan)
    - Gradle
2. **Clone repository atau download source code-nya.**
3. **Buka folder proyek di VSCode.**
4. **Jalankan perintah Gradle berikut di terminal:**

   ```bash
   ./gradlew run
   ```
5. **Aplikasi akan berjalan dan menampilkan tampilan utama Galeri Properti.**


---

## Author

| Nama                          | GitHub                                            |
| ----------------------------- | ------------------------------------------------- |
| Moch Ichwanul Muslimin Mayang | [NexonShoutt](https://github.com/NexonShoutt)     |
| Aisyah Salsabila Sabri        | [babssz](https://github.com/babssz)               |

---


