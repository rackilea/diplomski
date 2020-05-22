CREATE PROCEDURE `GET_NEW_ID`(IN V_TABLE VARCHAR(10), OUT V_ID VARCHAR(12))
BEGIN

    INSERT INTO seq_data (`name`, `stat_date`)
    SELECT V_TABLE, DATE_FORMAT(NOW(),'%Y%m%d') FROM seq_data WHERE name = V_TABLE AND stat_date = DATE_FORMAT(NOW(),'%Y%m%d');
    SET V_ID = concat(DATE_FORMAT(NOW(),'%y%m%d'),LPAD(LAST_INSERT_ID(), 6, '0'));

END