-- phpMyAdmin SQL Dump
-- version 6.0.0-dev+20260504.ec9afb2b86
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 07, 2026 at 08:58 AM
-- Server version: 8.4.3
-- PHP Version: 8.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pegawai_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `id_absen` int NOT NULL,
  `id_karyawan` int NOT NULL,
  `tanggal` date NOT NULL,
  `jam_masuk` time DEFAULT NULL,
  `jam_keluar` time DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `absensi`
--

INSERT INTO `absensi` (`id_absen`, `id_karyawan`, `tanggal`, `jam_masuk`, `jam_keluar`, `status`) VALUES
(58, 1, '2026-04-01', '08:27:00', '16:41:00', 'HADIR'),
(59, 1, '2026-04-02', '08:16:00', '16:44:00', 'HADIR'),
(60, 1, '2026-04-03', '08:22:00', '16:33:00', 'HADIR'),
(61, 1, '2026-04-04', '08:18:00', '16:05:00', 'HADIR'),
(62, 1, '2026-04-05', '08:01:00', '16:44:00', 'HADIR'),
(63, 1, '2026-04-06', '08:03:00', '16:56:00', 'HADIR'),
(64, 1, '2026-04-07', '08:26:00', '16:43:00', 'HADIR'),
(65, 1, '2026-04-08', '08:01:00', '16:49:00', 'HADIR'),
(66, 1, '2026-04-09', '08:04:00', '16:37:00', 'HADIR'),
(67, 1, '2026-04-10', '08:23:00', '16:36:00', 'HADIR'),
(68, 1, '2026-04-11', '08:07:00', '16:43:00', 'HADIR'),
(69, 1, '2026-04-12', '08:10:00', '16:05:00', 'HADIR'),
(70, 1, '2026-04-13', '08:22:00', '16:52:00', 'HADIR'),
(71, 1, '2026-04-14', '08:14:00', '16:51:00', 'HADIR'),
(72, 1, '2026-04-15', '08:06:00', '16:23:00', 'HADIR'),
(73, 1, '2026-04-16', '08:11:00', '16:39:00', 'HADIR'),
(74, 1, '2026-04-17', '08:11:00', '16:01:00', 'HADIR'),
(75, 1, '2026-04-18', '08:27:00', '16:11:00', 'HADIR'),
(76, 1, '2026-04-19', '08:04:00', '16:45:00', 'HADIR'),
(77, 1, '2026-04-20', '08:23:00', '16:35:00', 'HADIR'),
(78, 1, '2026-04-21', '08:12:00', '16:34:00', 'HADIR'),
(79, 1, '2026-04-22', '08:17:00', '16:30:00', 'HADIR'),
(80, 1, '2026-04-23', '08:27:00', '16:16:00', 'HADIR'),
(81, 1, '2026-04-24', '08:25:00', '16:14:00', 'HADIR'),
(82, 1, '2026-04-25', '08:26:00', '16:50:00', 'HADIR'),
(83, 1, '2026-04-26', '08:12:00', '16:31:00', 'HADIR'),
(84, 2, '2026-04-01', '08:20:00', '16:16:00', 'HADIR'),
(85, 2, '2026-04-02', '08:09:00', '16:52:00', 'HADIR'),
(86, 2, '2026-04-03', '08:19:00', '16:42:00', 'HADIR'),
(87, 2, '2026-04-04', '08:08:00', '16:35:00', 'HADIR'),
(88, 2, '2026-04-05', '08:21:00', '16:35:00', 'HADIR'),
(89, 2, '2026-04-06', '08:08:00', '16:52:00', 'HADIR'),
(90, 2, '2026-04-07', '08:10:00', '16:25:00', 'HADIR'),
(91, 2, '2026-04-08', '08:00:00', '16:06:00', 'HADIR'),
(92, 2, '2026-04-09', '08:13:00', '16:39:00', 'HADIR'),
(93, 2, '2026-04-10', '08:05:00', '16:13:00', 'HADIR'),
(94, 2, '2026-04-11', '08:02:00', '16:04:00', 'HADIR'),
(95, 2, '2026-04-12', '08:02:00', '16:04:00', 'HADIR'),
(96, 2, '2026-04-13', '08:04:00', '16:04:00', 'HADIR'),
(97, 2, '2026-04-14', '08:19:00', '16:49:00', 'HADIR'),
(98, 2, '2026-04-15', '08:06:00', '16:28:00', 'HADIR'),
(99, 2, '2026-04-16', '08:17:00', '16:53:00', 'HADIR'),
(100, 2, '2026-04-17', '08:13:00', '16:00:00', 'HADIR'),
(101, 2, '2026-04-18', '08:28:00', '16:32:00', 'HADIR'),
(102, 2, '2026-04-19', '08:24:00', '16:19:00', 'HADIR'),
(103, 2, '2026-04-20', '08:22:00', '16:05:00', 'HADIR'),
(104, 2, '2026-04-21', '08:25:00', '16:57:00', 'HADIR'),
(105, 2, '2026-04-22', '08:01:00', '16:18:00', 'HADIR'),
(106, 2, '2026-04-23', '08:12:00', '16:07:00', 'HADIR'),
(107, 2, '2026-04-24', '08:22:00', '16:33:00', 'HADIR'),
(209, 3, '2026-05-24', '12:03:27', '12:03:36', 'HADIR'),
(210, 1, '2026-05-01', '08:05:00', '16:30:00', 'HADIR'),
(211, 1, '2026-05-02', '08:10:00', '16:25:00', 'HADIR'),
(212, 1, '2026-05-03', '08:00:00', '16:40:00', 'HADIR'),
(213, 1, '2026-05-04', '08:15:00', '16:35:00', 'HADIR'),
(214, 1, '2026-05-05', '08:20:00', '16:45:00', 'HADIR'),
(215, 1, '2026-05-06', '08:05:00', '16:30:00', 'HADIR'),
(216, 1, '2026-05-07', '08:10:00', '16:50:00', 'HADIR'),
(217, 1, '2026-05-08', '08:00:00', '16:20:00', 'HADIR'),
(218, 1, '2026-05-09', '08:12:00', '16:33:00', 'HADIR'),
(219, 1, '2026-05-10', '08:08:00', '16:28:00', 'HADIR'),
(220, 1, '2026-05-11', '08:03:00', '16:31:00', 'HADIR'),
(221, 1, '2026-05-12', '08:17:00', '16:42:00', 'HADIR'),
(222, 1, '2026-05-13', '08:09:00', '16:29:00', 'HADIR'),
(223, 1, '2026-05-14', '08:11:00', '16:37:00', 'HADIR'),
(224, 1, '2026-05-15', '08:06:00', '16:34:00', 'HADIR'),
(225, 1, '2026-07-01', '19:37:55', '19:38:03', 'HADIR'),
(226, 4, '2026-07-01', '19:46:01', '19:46:14', 'HADIR'),
(228, 6, '2026-07-03', '14:23:58', '14:24:06', 'HADIR');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `nama`, `no_hp`, `alamat`) VALUES
(1, 'zacky', 'z123', NULL, NULL, NULL),
(2, 'ucup90', '1234', 'ucup12', '0897678', 'alskldadh'),
(3, 'Puspa14', 'bubu14', 'Puspa', '089673285480', 'Cijantung');

-- --------------------------------------------------------

--
-- Table structure for table `departement`
--

CREATE TABLE `departement` (
  `id_departement` int NOT NULL,
  `nama_departement` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`id_departement`, `nama_departement`) VALUES
(1, 'Finance & Accounting'),
(2, 'Marketing'),
(3, 'Information Technology (IT)'),
(4, 'Sales'),
(5, 'Operations'),
(7, 'Human Resource (HR)'),
(8, 'Keamanan'),
(12, 'Cyber Security');

-- --------------------------------------------------------

--
-- Table structure for table `detail_gaji`
--

CREATE TABLE `detail_gaji` (
  `id_gaji` int NOT NULL,
  `id_karyawan` int DEFAULT NULL,
  `nama_karyawan` varchar(100) DEFAULT NULL,
  `nama_jabatan` varchar(100) DEFAULT NULL,
  `nama_departement` varchar(100) DEFAULT NULL,
  `bulan` varchar(20) DEFAULT NULL,
  `total_hadir` int DEFAULT NULL,
  `bonus` decimal(15,2) DEFAULT NULL,
  `potongan` decimal(15,2) DEFAULT NULL,
  `total_gaji` decimal(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `detail_gaji`
--

INSERT INTO `detail_gaji` (`id_gaji`, `id_karyawan`, `nama_karyawan`, `nama_jabatan`, `nama_departement`, `bulan`, `total_hadir`, `bonus`, `potongan`, `total_gaji`) VALUES
(159, 1, 'Faisal Akbar', 'Manager Lapangan', 'Information Technology (IT)', 'April 2026', 26, 500000.00, 100000.00, 6400000.00),
(160, 2, 'haikal', 'Manager Lapangan', 'Information Technology (IT)', 'April 2026', 24, 0.00, 200000.00, 5338461.54),
(161, 3, 'ucup', 'Manager', 'Information Technology (IT)', 'April 2026', 0, 0.00, 0.00, 0.00),
(162, 4, 'Kicuy suripto', 'Security', 'Keamanan', 'April 2026', 0, 0.00, 0.00, 0.00),
(163, 6, 'rafi febriwan', 'Operator', 'Sales', 'April 2026', 0, 0.00, 0.00, 0.00),
(169, 1, 'Faisal Akbar', 'Manager Lapangan', 'Information Technology (IT)', 'Mei 2026', 15, 100000.00, 0.00, 3561538.46),
(170, 2, 'haikal', 'Manager Lapangan', 'Information Technology (IT)', 'Mei 2026', 0, 0.00, 0.00, 0.00),
(171, 3, 'ucup', 'Manager', 'Information Technology (IT)', 'Mei 2026', 0, 0.00, 0.00, 0.00),
(172, 4, 'Kicuy suripto', 'Security', 'Keamanan', 'Mei 2026', 0, 0.00, 0.00, 0.00),
(173, 6, 'rafi febriwan', 'Operator', 'Sales', 'Mei 2026', 0, 0.00, 0.00, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int NOT NULL,
  `nama_jabatan` varchar(100) NOT NULL,
  `gaji_pokok` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama_jabatan`, `gaji_pokok`) VALUES
(1, 'Manager', 8000000),
(2, 'Manager Lapangan', 6000000),
(3, 'Admin', 4000000),
(4, 'Supervisor', 6000000),
(5, 'Operator', 5000000),
(6, 'HR Staff', 12000000),
(7, 'Security', 4500000),
(8, 'Komisaris', 10000000),
(9, 'owner', 30000000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_jabatan` int DEFAULT NULL,
  `id_departement` int DEFAULT NULL,
  `nama_karyawan` varchar(100) NOT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `username`, `password`, `id_jabatan`, `id_departement`, `nama_karyawan`, `no_hp`, `alamat`) VALUES
(1, 'faisal12', '123456', 2, 3, 'Faisal Akbar', '089765467', 'jl.merdeka'),
(2, 'ical21', '1234', 2, 3, 'haikal', '08979675643', 'jl.marunda'),
(3, 'ucup12', 'qwertyucup', 1, 3, 'ucup', '08976564987', 'Jl. Raya Bekasi KM 18 No. 45, RT 05/RW 12, Kelurahan Cakung Barat, Kecamatan Cakung, Kota Jakarta Timur, DKI Jakarta 13910, Indonesia'),
(4, 'kicuy89', '109040', 7, 8, 'Kicuy suripto', '08999787867', 'jl.kedufan kapan kapan'),
(6, 'rafi06', '12345', 5, 4, 'rafi febriwan', '081774185971', 'ciracas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id_absen`),
  ADD UNIQUE KEY `unique_absen` (`id_karyawan`,`tanggal`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id_departement`);

--
-- Indexes for table `detail_gaji`
--
ALTER TABLE `detail_gaji`
  ADD PRIMARY KEY (`id_gaji`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD KEY `id_jabatan` (`id_jabatan`),
  ADD KEY `id_departement` (`id_departement`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absensi`
--
ALTER TABLE `absensi`
  MODIFY `id_absen` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=229;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `departement`
--
ALTER TABLE `departement`
  MODIFY `id_departement` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `detail_gaji`
--
ALTER TABLE `detail_gaji`
  MODIFY `id_gaji` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=179;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absensi`
--
ALTER TABLE `absensi`
  ADD CONSTRAINT `absensi_ibfk_1` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_ibfk_1` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`),
  ADD CONSTRAINT `karyawan_ibfk_2` FOREIGN KEY (`id_departement`) REFERENCES `departement` (`id_departement`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
