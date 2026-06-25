-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2026 at 02:54 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `judul` varchar(200) NOT NULL,
  `pengarang` varchar(200) DEFAULT NULL,
  `penerbit` varchar(200) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `stok` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `pengarang`, `penerbit`, `tahun`, `stok`, `created_at`) VALUES
(3, 'Naruto Bind Up Edition 11', 'Masashi Kishimoto', 'Elex Media Komputindo', 2024, 9, '2026-05-29 14:00:58'),
(4, 'Laskar Pelangi', 'Andrea Hirata', 'Bentang Pustaka', 2005, 10, '2026-06-25 12:37:24'),
(5, 'Bumi Manusia', 'Pramoedya Ananta Toer', 'Lentera Dipantara', 1980, 8, '2026-06-25 12:37:24'),
(6, 'Negeri 5 Menara', 'Ahmad Fuadi', 'Gramedia', 2009, 12, '2026-06-25 12:37:24'),
(7, 'Ayat-Ayat Cinta', 'Habiburrahman El Shirazy', 'Republika', 2004, 7, '2026-06-25 12:37:24'),
(8, 'Dilan 1990', 'Pidi Baiq', 'Pastel Books', 2014, 15, '2026-06-25 12:37:24'),
(9, 'Pulang', 'Tere Liye', 'Republika', 2015, 9, '2026-06-25 12:37:24'),
(10, 'Hujan', 'Tere Liye', 'Gramedia', 2016, 11, '2026-06-25 12:37:24'),
(11, 'Rindu', 'Tere Liye', 'Republika', 2014, 6, '2026-06-25 12:37:24'),
(12, 'Atomic Habits', 'James Clear', 'Gramedia', 2018, 10, '2026-06-25 12:37:24'),
(13, 'Rich Dad Poor Dad', 'Robert T. Kiyosaki', 'Gramedia', 1997, 8, '2026-06-25 12:37:24'),
(14, 'The Psychology of Money', 'Morgan Housel', 'Harriman House', 2020, 13, '2026-06-25 12:37:24'),
(15, 'Deep Work', 'Cal Newport', 'Grand Central Publishing', 2016, 7, '2026-06-25 12:37:24'),
(16, 'Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008, 5, '2026-06-25 12:37:24'),
(17, 'Head First Java', 'Kathy Sierra', 'O\'Reilly Media', 2005, 6, '2026-06-25 12:37:24'),
(18, 'Effective Java', 'Joshua Bloch', 'Addison-Wesley', 2018, 4, '2026-06-25 12:37:24'),
(19, 'Pemrograman Java Dasar', 'Abdul Kadir', 'Andi Offset', 2019, 14, '2026-06-25 12:37:24'),
(20, 'Basis Data', 'Rosa A.S.', 'Informatika', 2018, 10, '2026-06-25 12:37:24'),
(21, 'Algoritma dan Pemrograman', 'Munir', 'Informatika', 2017, 9, '2026-06-25 12:37:24'),
(22, 'Struktur Data', 'Narasimha Karumanchi', 'CareerMonk', 2011, 5, '2026-06-25 12:37:24'),
(23, 'Belajar SQL', 'Budi Raharjo', 'Informatika', 2021, 12, '2026-06-25 12:37:24'),
(24, 'Filosofi Teras', 'Henry Manampiring', 'Kompas', 2018, 10, '2026-06-25 12:51:23'),
(25, 'Sebuah Seni untuk Bersikap Bodo Amat', 'Mark Manson', 'Gramedia', 2017, 9, '2026-06-25 12:51:54'),
(26, 'Think and Grow Rich', 'Napoleon Hill', 'The Ralston Society', 1937, 6, '2026-06-25 12:51:54'),
(27, 'The 7 Habits of Highly Effective People', 'Stephen R. Covey', 'Free Press', 1989, 8, '2026-06-25 12:51:54'),
(28, 'Start With Why', 'Simon Sinek', 'Portfolio', 2009, 7, '2026-06-25 12:51:54'),
(29, 'Zero to One', 'Peter Thiel', 'Crown Business', 2014, 5, '2026-06-25 12:51:54'),
(30, 'The Lean Startup', 'Eric Ries', 'Crown Business', 2011, 8, '2026-06-25 12:51:54'),
(31, 'Rework', 'Jason Fried', 'Crown Business', 2010, 6, '2026-06-25 12:51:54'),
(32, 'Design Patterns', 'Erich Gamma', 'Addison-Wesley', 1994, 4, '2026-06-25 12:51:54'),
(33, 'Introduction to Algorithms', 'Thomas H. Cormen', 'MIT Press', 2009, 5, '2026-06-25 12:51:54'),
(34, 'Computer Networking', 'Andrew S. Tanenbaum', 'Pearson', 2011, 7, '2026-06-25 12:51:54'),
(35, 'Operating System Concepts', 'Abraham Silberschatz', 'Wiley', 2018, 5, '2026-06-25 12:51:54'),
(36, 'Artificial Intelligence: A Modern Approach', 'Stuart Russell', 'Pearson', 2020, 3, '2026-06-25 12:51:54'),
(37, 'Machine Learning with Python', 'Sebastian Raschka', 'Packt', 2019, 6, '2026-06-25 12:51:54'),
(38, 'Python Crash Course', 'Eric Matthes', 'No Starch Press', 2019, 8, '2026-06-25 12:51:54'),
(39, 'Learning PHP, MySQL & JavaScript', 'Robin Nixon', 'O\'Reilly Media', 2018, 7, '2026-06-25 12:51:54'),
(40, 'Laravel Up & Running', 'Matt Stauffer', 'O\'Reilly Media', 2019, 6, '2026-06-25 12:51:54'),
(41, 'Spring in Action', 'Craig Walls', 'Manning', 2022, 4, '2026-06-25 12:51:54'),
(42, 'Android Programming', 'Bill Phillips', 'Big Nerd Ranch', 2019, 5, '2026-06-25 12:51:54'),
(43, 'Kotlin in Action', 'Dmitry Jemerov', 'Manning', 2017, 5, '2026-06-25 12:51:54'),
(44, 'Flutter for Beginners', 'Alessandro Biessek', 'Packt', 2021, 9, '2026-06-25 12:51:54'),
(45, 'Belajar JavaScript', 'Wahyu Unnisa', 'Informatika', 2022, 10, '2026-06-25 12:51:54'),
(46, 'HTML & CSS Dasar', 'Jubilee Enterprise', 'Elex Media', 2020, 12, '2026-06-25 12:51:54'),
(47, 'Pemrograman Web Modern', 'Budi Raharjo', 'Informatika', 2021, 11, '2026-06-25 12:51:54'),
(48, 'Jaringan Komputer', 'Onno W. Purbo', 'Andi Offset', 2017, 8, '2026-06-25 12:51:54'),
(49, 'Keamanan Jaringan', 'Budi Irawan', 'Informatika', 2019, 6, '2026-06-25 12:51:54'),
(50, 'Cloud Computing', 'Rajkumar Buyya', 'Wiley', 2013, 4, '2026-06-25 12:51:54'),
(51, 'Data Mining', 'Jiawei Han', 'Morgan Kaufmann', 2011, 5, '2026-06-25 12:51:54'),
(52, 'Big Data Fundamentals', 'Thomas Erl', 'Prentice Hall', 2015, 6, '2026-06-25 12:51:54'),
(53, 'Software Engineering', 'Ian Sommerville', 'Pearson', 2016, 5, '2026-06-25 12:51:54');

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `id` int(11) NOT NULL,
  `peminjaman_id` int(11) NOT NULL,
  `buku_id` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id`, `peminjaman_id`, `buku_id`, `jumlah`) VALUES
(5, 5, 3, 1),
(6, 6, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `favorit`
--

CREATE TABLE `favorit` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `buku_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `favorit`
--

INSERT INTO `favorit` (`id`, `user_id`, `buku_id`, `created_at`) VALUES
(4, 4, 3, '2026-05-29 14:14:26');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `tanggal_kembali_aktual` date DEFAULT NULL,
  `status` enum('dipinjam','dikembalikan','terlambat') DEFAULT 'dipinjam',
  `denda` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `diproses_oleh` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `user_id`, `tanggal_pinjam`, `tanggal_kembali`, `tanggal_kembali_aktual`, `status`, `denda`, `created_at`, `diproses_oleh`) VALUES
(3, 4, '2026-05-28', '2026-06-04', NULL, 'dikembalikan', 0, '2026-05-28 12:29:00', NULL),
(4, 4, '2026-05-28', '2026-06-04', NULL, 'dipinjam', 0, '2026-05-28 13:18:32', NULL),
(5, 4, '2026-05-29', '2026-06-05', NULL, 'dikembalikan', 0, '2026-05-29 14:14:33', 'admin'),
(6, 4, '2026-06-02', '2026-06-09', NULL, 'dipinjam', 0, '2026-06-02 09:09:54', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','user') NOT NULL DEFAULT 'user',
  `nama_lengkap` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `status` enum('aktif','nonaktif') DEFAULT 'aktif',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`, `nama_lengkap`, `email`, `no_hp`, `alamat`, `status`, `created_at`) VALUES
(2, 'admin', '$2a$10$XRV8duFPFjUa3HrMaUOB5eV48Vp9266HaJrQJ/5fBY5k7h9aaKPnW', 'admin', 'admin', 'admin@gmail.com', '0857575775', 'Indonesia', 'aktif', '2026-05-26 16:53:16'),
(4, 'user', '$2a$10$8ChRNasTUB77o78GYmQB2Oq8ViPmSraT5VQ477bvwLWasDsyXjyb.', 'user', 'user', NULL, '0123456789', 'Indonesia', 'aktif', '2026-05-28 11:51:52');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `peminjaman_id` (`peminjaman_id`),
  ADD KEY `buku_id` (`buku_id`);

--
-- Indexes for table `favorit`
--
ALTER TABLE `favorit`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_favorit` (`user_id`,`buku_id`),
  ADD KEY `buku_id` (`buku_id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `favorit`
--
ALTER TABLE `favorit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD CONSTRAINT `detail_peminjaman_ibfk_1` FOREIGN KEY (`peminjaman_id`) REFERENCES `peminjaman` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `detail_peminjaman_ibfk_2` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `favorit`
--
ALTER TABLE `favorit`
  ADD CONSTRAINT `favorit_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `favorit_ibfk_2` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
