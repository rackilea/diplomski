DROP TABLE IF EXISTS T,T1;

CREATE TABLE T(ID INT AUTO_INCREMENT PRIMARY KEY,IDPRD VARCHAR(10), INSTOCK INT);
CREATE TABLE T1(ID INT AUTO_INCREMENT PRIMARY KEY,IDPRD VARCHAR(10), INSTOCK INT);

DROP PROCEDURE IF EXISTS P;
DELIMITER $$
CREATE PROCEDURE P(INPRD VARCHAR(10),INAMT INT)
BEGIN
DECLARE CONT INT DEFAULT 1;
declare finished int default 0;
declare vid int;
declare vidprd varchar(10);
declare vinstock int;
DECLARE cur CURSOR FOR select id,idprd,instock from t where instock > 0 order by id;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

SELECT  CASE WHEN SUM(INSTOCK) < INAMT THEN 0 ELSE 1 END INTO CONT FROM T WHERE IDPRD = INPRD GROUP BY IDPRD;

if cont = 1 then
    start transaction;
    insert into t1(idprd,instock) values(inprd,inamt);
    open cur;
    fetch cur into vid,vidprd,vinstock;
    curloop: loop
        if finished = 1 or inamt = 0 then
            leave curloop;
        end if;
        if vinstock >= inamt then
            update t 
                set instock = instock - inamt
                where id = vid and idprd = vidprd;
            set inamt = 0;
         else
            update t
                set instock = 0
                where id = vid and idprd = vidprd;
            set inamt = inamt - vinstock;
        fetch cur into vid,vidprd,vinstock;
       end if;
    end loop curloop;

    commit;

end if;

END $$
DELIMITER :


truncate table t;
INSERT INTO T(IDPRD,INSTOCK) VALUES ('A1',100),('A1',100);

truncate table t1;
CALL P('A1',120);

select 't', t.* from t
union all
select 't1',t1.* from t1;

+----+----+-------+---------+
| t  | ID | IDPRD | INSTOCK |
+----+----+-------+---------+
| t  |  1 | A1    |       0 |
| t  |  2 | A1    |      80 |
| t1 |  1 | A1    |       0 |
+----+----+-------+---------+
3 rows in set (0.00 sec)