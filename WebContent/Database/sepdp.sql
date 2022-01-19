/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 6.0.11-alpha-community : Database - sepdp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`sepdp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sepdp`;

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `fid` varchar(6) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `filedata` mediumblob NOT NULL,
  `owneremailid` varchar(100) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `file` */

insert  into `file`(`fid`,`fname`,`filedata`,`owneremailid`) values ('c5578','possession','T��J�b��x��dy���-�.Z�\0����	=�\rQY�.=XH���2#���ت�c$� Fa�:\\����ϝ�a�0�I��Z<���.r�A�]&k���J��9I�\r�>m8���6#U�&���0���=F6G���k=V�	�j9P;K����C}�7�z�O5<!V\nߒ^߬�-d����-�ܴ�;Dҏ׿���p}��H��5V���6x)c�py�Eɂ��?&��GK2Ч��<k`Pn�Rzϰ�TV�k>:�(F�Ux�ܹ���HZ��2ULx2h;��Äq@����Q&�|�\'���;o�H�+������3N�\r��v��u�y��\\��6m!�zb��|�S��\n��g&��TZ)k7�P�=�q���q','dataowner@gmail.com');

/*Table structure for table `reg` */

DROP TABLE IF EXISTS `reg`;

CREATE TABLE `reg` (
  `name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(10) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL,
  `usertype` varchar(20) NOT NULL,
  `status` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reg` */

insert  into `reg`(`name`,`email`,`password`,`phone`,`city`,`usertype`,`status`) values ('csp','csp@gmail.com','csp','7729043377','pamarru','csp','1'),('dataowner','dataowner@gmail.com','do','7729043377','pamarru','owner','1'),('sai1','sai1@gmail.com','sai','7729043377','pamarru','user','1'),('sai','sai@gmail.com','sai','7729043377','pamarru','user','1'),('tpa','tpa@gmail.com','tpa','4155454785','pamarru','tpa','1');

/*Table structure for table `sharedfiles` */

DROP TABLE IF EXISTS `sharedfiles`;

CREATE TABLE `sharedfiles` (
  `sid` int(5) NOT NULL AUTO_INCREMENT,
  `fid` varchar(5) NOT NULL,
  `useremailid` varchar(40) NOT NULL,
  `filekey` varchar(5) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

/*Data for the table `sharedfiles` */

insert  into `sharedfiles`(`sid`,`fid`,`useremailid`,`filekey`,`status`) values (50,'c5578','sai@gmail.com','34efb','2'),(51,'c5578','sai@gmail.com','e6b4b','1');

/*Table structure for table `signature` */

DROP TABLE IF EXISTS `signature`;

CREATE TABLE `signature` (
  `fid` varchar(6) NOT NULL,
  `signature` varchar(200) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `signature` */

insert  into `signature`(`fid`,`signature`) values ('c5578','6982952a4c17c95f490dfaa7259b5a24627b3eb1de58f39c3db2790653738a55');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
