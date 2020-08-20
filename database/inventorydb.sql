/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.1.36-MariaDB : Database - inventorydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inventorydb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inventorydb`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `brand` */

insert  into `brand`(`id`,`brand`,`status`) values (2,'Huawei','Active'),(3,'Nokia','Not Active'),(4,'Samsung','Active'),(5,'Devant','Active'),(6,'oppo','Active');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`category`,`status`) values (1,'Smart Phone','Active'),(2,'Laptop','Not Active'),(3,'Gadget','Active'),(4,'Appliances','Active');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `product` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `brandid` int(1) NOT NULL,
  `categoryid` int(1) NOT NULL,
  `costprice` int(11) NOT NULL,
  `retailprice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `barcode` int(11) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `brandid` (`brandid`),
  KEY `categoryid` (`categoryid`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`brandid`) REFERENCES `brand` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`id`,`product`,`description`,`brandid`,`categoryid`,`costprice`,`retailprice`,`quantity`,`barcode`,`status`) values (8,'Huawei Y9','New',2,1,6000,5999,25,5125,'Available'),(9,'Nokia C3','keyboard',3,3,2000,1999,15,6994,'Available');

/*Table structure for table `salerecord` */

DROP TABLE IF EXISTS `salerecord`;

CREATE TABLE `salerecord` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `subtotal` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `balance` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `salerecord` */

insert  into `salerecord`(`id`,`date`,`subtotal`,`pay`,`balance`) values (7,'2020-08-17',11998,12000,2),(8,'2020-08-17',17997,18000,3),(9,'2020-08-17',9995,10000,5);

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `saleid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `sellprice` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `productid` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `sales` */

insert  into `sales`(`id`,`saleid`,`productid`,`sellprice`,`quantity`,`total`) values (6,7,5125,5999,2,11998),(7,8,5125,5999,3,17997),(8,9,6994,1999,5,9995);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
