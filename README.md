# AppUserRoom

Aplikasi Android sederhana untuk mengelola data pengguna (User) menggunakan **Room Database** dengan bahasa pemrograman Kotlin.

Project ini dibuat sebagai implementasi materi Android Development Modul 2, yaitu penggunaan Room Database untuk menyimpan dan mengelola data secara lokal.

## Fitur Aplikasi

- Menambahkan data pengguna (Create).
- Menampilkan daftar pengguna (Read).
- Mengubah data pengguna (Update).
- Menghapus data pengguna (Delete).
- Menyimpan data secara lokal menggunakan Room Database.

## Teknologi yang Digunakan

- **Bahasa Pemrograman:** Kotlin
- **IDE:** Android Studio
- **Database:** Room Database
- **Architecture:** ViewModel dan LiveData
- **UI:** XML Layout
- **List Component:** RecyclerView
- **Database Processing:** KSP

## Struktur Project

```text
AppUserRoom/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/lat/pam/appuserroom/
│           │   ├── MainActivity.kt
│           │   ├── User.kt
│           │   ├── UserDao.kt
│           │   ├── AppDatabase.kt
│           │   ├── UserViewModel.kt
│           │   └── UserAdapter.kt
│           │
│           └── res/
│               └── layout/
│                   ├── activity_main.xml
│                   └── item_user.xml
│
├── build.gradle.kts
└── README.md
```

## Cara Menjalankan Project

1. Download atau clone repository ini.
2. Buka project menggunakan Android Studio.
3. Tunggu proses Gradle Sync sampai selesai.
4. Jalankan aplikasi menggunakan emulator atau perangkat Android.
5. Aplikasi siap digunakan untuk mengelola data pengguna.

## Cara Kerja Aplikasi

Aplikasi menggunakan Room Database untuk menyimpan data pengguna yang terdiri dari ID, nama, dan email.

Data dikelola melalui UserDao, kemudian dihubungkan dengan UserViewModel. LiveData digunakan untuk mengamati perubahan data sehingga daftar pengguna dapat diperbarui secara otomatis pada RecyclerView.

## Identitas Project

- **Nama Project:** AppUserRoom
- **Package Name:** lat.pam.appuserroom
- **Mata Kuliah:** Pemrograman Aplikasi Mobile
- **Modul:** Modul 2 – Room Database

---

Dibuat sebagai project pembelajaran Android menggunakan Kotlin dan Room Database.
