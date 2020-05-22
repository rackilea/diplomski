CREATE TABLE `assignment` (
`id` INT(11) NOT NULL,
`firstname` VARCHAR(30) DEFAULT NULL,
`lastname` VARCHAR(30) DEFAULT NULL,
`email` VARCHAR(30) DEFAULT NULL,
`status` CHAR(1) DEFAULT NULL,
PRIMARY KEY (`id`)
) 

/*Data for the table `assignment` */

INSERT  INTO `assignment`(`id`,`firstname`,`lastname`,`email`,`status`) VALUES (1,'rohit','gaikwad','rohitgaikwad@xyz.com','I');