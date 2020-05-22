CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`(IN username VARCHAR(250), IN pwd VARCHAR (100))
BEGIN

SET @s = CONCAT('CREATE USER "',username,'"@"localhost" IDENTIFIED BY "',pwd,'"');
PREPARE stmt FROM @s;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
END