-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2017 at 04:05 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `17spjohnsoerjawitaka`
--
CREATE DATABASE IF NOT EXISTS `17spjohnsoerjawitaka` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `17spjohnsoerjawitaka`;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `MiddleName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) NOT NULL,
  `BirthDate` datetime NOT NULL,
  `HireDate` datetime NOT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `Rate` decimal(10,2) DEFAULT NULL,
  `AvgWeeklyHours` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `BirthDate`, `HireDate`, `Salary`, `Rate`, `AvgWeeklyHours`) VALUES
(65, 'Aaron', 'A', 'Aaronson', '1980-01-01 00:00:00', '2013-01-02 00:00:00', '50000.00', NULL, NULL),
(66, 'Erin', 'E', 'Erinson', '1980-01-01 00:00:00', '2012-01-01 00:00:00', '52000.00', NULL, NULL),
(456, 'Jack', NULL, 'Daniels', '1959-09-29 00:00:00', '2017-04-15 00:00:00', NULL, NULL, NULL),
(734, 'Roy', '', 'Batty', '2016-01-08 00:00:00', '2016-01-09 00:00:00', NULL, NULL, NULL),
(1119, 'Rebecca', 'L', 'Romijn', '1979-06-09 00:00:00', '1979-06-10 00:00:00', NULL, NULL, NULL),
(1313, 'Beatrix', NULL, 'Kiddo', '1976-02-28 00:00:00', '2003-10-10 00:00:00', NULL, '1000.50', '5.00'),
(1337, 'Molly', NULL, 'Millions', '1984-07-01 00:00:00', '2000-04-29 00:00:00', NULL, '1200.00', '4.00'),
(1985, 'Marty', NULL, 'McFly', '1968-06-12 00:00:00', '1885-01-01 00:00:00', NULL, '8.75', '20.00'),
(2000, 'Paul', 'Muad\'Dib', 'Atreides', '1965-04-04 00:00:00', '1984-05-05 00:00:00', '123000.00', NULL, NULL),
(5150, 'Eduardo', 'FlyingV', 'VanHalen', '1969-06-09 00:00:00', '2005-05-05 00:00:00', '10000000.00', NULL, NULL),
(5558, 'Morgan', NULL, 'Freeman', '1899-12-31 00:00:00', '1900-01-01 00:00:00', NULL, NULL, NULL),
(6557, 'James', 'Lynn', 'O\'Flaherty', '2001-02-14 00:00:00', '2019-02-14 00:00:00', NULL, '12.00', '40.00'),
(7721, 'Russel', 'Crow', 'Johnson', '1928-11-16 00:00:00', '2014-12-15 00:00:00', NULL, NULL, NULL),
(9874, 'Molly', NULL, 'O\'Brien', '1989-08-03 00:00:00', '1999-04-15 00:00:00', NULL, NULL, NULL),
(9999, 'Arron', 'Sergie', 'Smith', '1901-01-01 00:00:00', '2015-06-04 00:00:00', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
