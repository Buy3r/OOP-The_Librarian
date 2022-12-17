-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2022 at 05:26 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Author` text NOT NULL,
  `Genre` text NOT NULL,
  `Date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Name`, `Author`, `Genre`, `Date`) VALUES
(1, 'Book1', 'Author1', 'xxxx', 'xx/xx/xx'),
(2, 'Book2', 'Author2', 'xxxx', 'xx/xx/xx'),
(3, 'Book3', 'Author3', 'xxxx', 'xx/xx/xx'),
(4, 'Book4', 'Author4', 'xxxx', 'xx/xx/xx'),
(5, 'Book5', 'Author5', 'xxxx', 'xx/xx/xx'),
(6, 'Book6', 'Author6', 'xxxx', 'xx/xx/xx');

-- --------------------------------------------------------

--
-- Table structure for table `issued_book`
--

CREATE TABLE `issued_book` (
  `id` int(11) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `mem_id` varchar(20) NOT NULL,
  `mem_name` varchar(100) NOT NULL,
  `issue_date` varchar(20) NOT NULL,
  `return_date` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `issued_book`
--

INSERT INTO `issued_book` (`id`, `book_id`, `mem_id`, `mem_name`, `issue_date`, `return_date`, `status`) VALUES
(1, '1  Book1', '1', 'Fname1 Lname1', '2022-12-16', '2022-12-22', 'returned'),
(2, '3  Book3', '3', 'Fname1 Lname1', '2022-12-16', '2022-12-22', 'pending'),
(3, '5  Book5', '1', 'Fname1 Lname1', '2022-12-16', '2022-12-22', 'returned'),
(4, '1  Book1', '2', 'Fname1 Lname1', '17-12-2022', '22-12-2022', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `ID` int(255) NOT NULL,
  `Fname` text NOT NULL,
  `Lname` text NOT NULL,
  `Phone` text NOT NULL,
  `Email` text NOT NULL,
  `Gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`ID`, `Fname`, `Lname`, `Phone`, `Email`, `Gender`) VALUES
(1, 'Fname1', 'Lname1', 'xxxx', 'xxxx', 'xxxx'),
(2, 'Fname2', 'Lname2', 'xxxx', 'xxxx', 'xxxx'),
(3, 'Fname3', 'Lname3', 'xxxx', 'xxxx', 'xxxx');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `telephone`) VALUES
(1, 'Admin', '1234', 'xxxx', '098xxxxxxx'),
(2, 'Test', 'test', 'xx', 'xx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `issued_book`
--
ALTER TABLE `issued_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issued_book`
--
ALTER TABLE `issued_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
