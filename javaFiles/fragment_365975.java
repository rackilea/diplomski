CREATE TABLE `pages` (
  `id` int(11) NOT NULL auto_increment,
  `part_of_page` varchar(30) NOT NULL,
  `actual_text` varchar(300) NOT NULL,
  PRIMARY KEY  (`id`)
) CHARACTER SET `utf8`;