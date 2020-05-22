DELIMITER $$
CREATE TRIGGER table1_trigger
BEFORE INSERT ON table1
FOR EACH ROW
BEGIN
DECLARE postfix INT(4) ZEROFILL;
DECLARE newID varchar(10);

SET @prefix = DATE_FORMAT(CURDATE(),'%y%m');
SET @wlike = CONCAT(@prefix, '%');
SET @previous_id = (SELECT id FROM table1 WHERE id LIKE @wlike ORDER BY id DESC LIMIT 1);
SET postfix = CAST(SUBSTRING(@previous_id, 5, 8) AS SIGNED);

IF postfix != 9999 THEN
  SET postfix = postfix + 1;
END IF;

SET NEW.id = CONCAT(@prefix, postfix);
END$$
DELIMITER;