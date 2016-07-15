/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.1.73-log : Database - monitor
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `host_info` */

DROP TABLE IF EXISTS `host_info`;

CREATE TABLE `host_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `ip` varchar(256) DEFAULT NULL,
  `port` varchar(256) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `host_info` */

LOCK TABLES `host_info` WRITE;

insert  into `host_info`(`id`,`name`,`ip`,`port`,`update_time`,`create_time`) values (1,'a','192.168.100.129','8080','2016-07-15 16:14:42',NULL),(2,'a','192.168.100.129','8080',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `monitor_error_log` */

DROP TABLE IF EXISTS `monitor_error_log`;

CREATE TABLE `monitor_error_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host_id` int(11) DEFAULT NULL,
  `log` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monitor_error_log` */

LOCK TABLES `monitor_error_log` WRITE;

UNLOCK TABLES;

/*Table structure for table `monitor_instance` */

DROP TABLE IF EXISTS `monitor_instance`;

CREATE TABLE `monitor_instance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host_id` int(11) DEFAULT NULL,
  `juid` varchar(128) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `request_method` varchar(64) DEFAULT NULL,
  `request_params` varchar(512) DEFAULT NULL,
  `content_type` varchar(256) DEFAULT NULL,
  `max_conn` int(11) DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `is_enable` int(1) DEFAULT NULL,
  `is_del` int(1) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monitor_instance` */

LOCK TABLES `monitor_instance` WRITE;

UNLOCK TABLES;

/*Table structure for table `monitor_instance_log` */

DROP TABLE IF EXISTS `monitor_instance_log`;

CREATE TABLE `monitor_instance_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monitor_instance_id` int(11) DEFAULT NULL,
  `conn_time` int(11) DEFAULT NULL,
  `received_size` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monitor_instance_log` */

LOCK TABLES `monitor_instance_log` WRITE;

UNLOCK TABLES;

/*Table structure for table `monitor_instance_log_text` */

DROP TABLE IF EXISTS `monitor_instance_log_text`;

CREATE TABLE `monitor_instance_log_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monitor_instance_log_id` int(11) DEFAULT NULL,
  `received_content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `monitor_instance_log_text` */

LOCK TABLES `monitor_instance_log_text` WRITE;

UNLOCK TABLES;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

LOCK TABLES `user_info` WRITE;

insert  into `user_info`(`id`,`user_name`,`password`,`email`,`create_time`,`update_time`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3',NULL,NULL,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
