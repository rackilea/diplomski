CREATE TABLE IF NOT EXISTS `unicodeinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(21) COLLATE utf8_unicode_ci NOT NULL,
  `Language` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Message` varchar(150) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;