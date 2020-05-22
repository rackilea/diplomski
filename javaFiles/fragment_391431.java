CREATE TABLE `user_accounts` (
       `user_identity` int(11) NOT NULL AUTO_INCREMENT,
       `username` varchar(50) NOT NULL,
       `surname` varchar(50) NOT NULL,
       `first_name` varchar(50) DEFAULT NULL,
       PRIMARY KEY (`user_identity`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;