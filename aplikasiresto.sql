-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Jan 2024 pada 16.15
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasiresto`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `makanan`
--

CREATE TABLE `makanan` (
  `kodeMakanan` int(11) NOT NULL,
  `Nama_Makanan` varchar(20) NOT NULL,
  `Harga` int(11) NOT NULL,
  `StokMakanan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `makanan`
--

INSERT INTO `makanan` (`kodeMakanan`, `Nama_Makanan`, `Harga`, `StokMakanan`) VALUES
(1, 'Bakso Urat', 20000, 30),
(2, 'bakso iga', 30000, 20);

-- --------------------------------------------------------

--
-- Struktur dari tabel `minuman`
--

CREATE TABLE `minuman` (
  `KodeMinuman` int(11) NOT NULL,
  `Nama_Minuman` varchar(20) NOT NULL,
  `Harga` int(11) NOT NULL,
  `StokMinuman` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `minuman`
--

INSERT INTO `minuman` (`KodeMinuman`, `Nama_Minuman`, `Harga`, `StokMinuman`) VALUES
(1, 'Es Jeruk', 7000, 20),
(2, 'Es Teh Manis', 6000, 15),
(3, 'Es Teh Lemon', 7000, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `KodeAdmin` int(10) NOT NULL,
  `namaAdmin` varchar(20) NOT NULL,
  `noTelpAdmin` varchar(15) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`KodeAdmin`, `namaAdmin`, `noTelpAdmin`, `alamat`, `username`, `Password`) VALUES
(1, 'Zidan', '08938472321', 'cimahi', 'Zidani', '1234'),
(2, 'Aminuddin', '0895323452299', 'cisarua', 'Amin', 'Amin123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kasir`
--

CREATE TABLE `tb_kasir` (
  `Kode_Kasir` int(10) NOT NULL,
  `Nama_Kasir` varchar(30) NOT NULL,
  `No_Telp` varchar(15) NOT NULL,
  `alamat` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_kasir`
--

INSERT INTO `tb_kasir` (`Kode_Kasir`, `Nama_Kasir`, `No_Telp`, `alamat`) VALUES
(1, 'ihsan', '08943848374', 'cisarua');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_meja`
--

CREATE TABLE `tb_meja` (
  `No_Meja` int(2) NOT NULL,
  `Kelas_Meja` varchar(20) NOT NULL,
  `Jumlah_Pesanan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_meja`
--

INSERT INTO `tb_meja` (`No_Meja`, `Kelas_Meja`, `Jumlah_Pesanan`) VALUES
(1, 'Normal', 2),
(2, 'Premium', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pembayaran`
--

CREATE TABLE `tb_pembayaran` (
  `Kode_Faktur` varchar(10) NOT NULL,
  `Tanggal_Faktur` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_pembayaran`
--

INSERT INTO `tb_pembayaran` (`Kode_Faktur`, `Tanggal_Faktur`) VALUES
('KF1', '2024-01-10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pesanmenu`
--

CREATE TABLE `tb_pesanmenu` (
  `kodePesan` int(10) NOT NULL,
  `namaMenu` varchar(20) NOT NULL,
  `hargaMenu` int(5) NOT NULL,
  `jumlahMenu` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_pesanmenu`
--

INSERT INTO `tb_pesanmenu` (`kodePesan`, `namaMenu`, `hargaMenu`, `jumlahMenu`) VALUES
(1, 'bakso urat', 20000, 4),
(2, 'es jeruk', 7000, 3),
(3, 'es teh manis', 5000, 1),
(4, 'bakso urat', 20000, 2),
(5, 'bakso Urat', 30000, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`username`, `password`) VALUES
('Aminuddin ihsan', 'ihsan123'),
('des', 'des123'),
('fajar ', 'fajar123'),
('ihsan20', '1234');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`kodeMakanan`);

--
-- Indeks untuk tabel `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`KodeMinuman`);

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`KodeAdmin`);

--
-- Indeks untuk tabel `tb_kasir`
--
ALTER TABLE `tb_kasir`
  ADD PRIMARY KEY (`Kode_Kasir`);

--
-- Indeks untuk tabel `tb_meja`
--
ALTER TABLE `tb_meja`
  ADD PRIMARY KEY (`No_Meja`);

--
-- Indeks untuk tabel `tb_pembayaran`
--
ALTER TABLE `tb_pembayaran`
  ADD PRIMARY KEY (`Kode_Faktur`);

--
-- Indeks untuk tabel `tb_pesanmenu`
--
ALTER TABLE `tb_pesanmenu`
  ADD PRIMARY KEY (`kodePesan`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
