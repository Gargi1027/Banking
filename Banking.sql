-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 06, 2016 at 04:51 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ftbanking`
--
CREATE DATABASE `ftbanking` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ftbanking`;

-- --------------------------------------------------------

--
-- Table structure for table `tblaccount`
--

CREATE TABLE IF NOT EXISTS `tblaccount` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT,
  `custId` int(11) NOT NULL,
  `balance` decimal(10,2) DEFAULT '0.00',
  `isActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblaccount`
--

INSERT INTO `tblaccount` (`accountId`, `custId`, `balance`, `isActive`) VALUES
(1, 1, '500.00', 1),
(2, 2, '100000.00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tblcustomer`
--

CREATE TABLE IF NOT EXISTS `tblcustomer` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblcustomer`
--

INSERT INTO `tblcustomer` (`custId`, `firstName`, `lastName`) VALUES
(1, 'Dhaval', 'Patel'),
(2, 'Neal ', 'Patel');

-- --------------------------------------------------------

--
-- Table structure for table `tblteller`
--

CREATE TABLE IF NOT EXISTS `tblteller` (
  `TELLERID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(100) DEFAULT NULL,
  `LASTNAME` varchar(100) DEFAULT NULL,
  `USERID` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TELLERID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tblteller`
--

INSERT INTO `tblteller` (`TELLERID`, `FIRSTNAME`, `LASTNAME`, `USERID`, `PASSWORD`) VALUES
(1, 'manan', 'lal', 'manu', 'manu');

-- --------------------------------------------------------

--
-- Table structure for table `tbltransaction`
--

CREATE TABLE IF NOT EXISTS `tbltransaction` (
  `transID` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) DEFAULT NULL,
  `transDate` datetime DEFAULT NULL,
  `transType` int(11) DEFAULT NULL,
  `transferToAccountId` int(11) DEFAULT NULL,
  `transAmount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`transID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbltransaction`
--

