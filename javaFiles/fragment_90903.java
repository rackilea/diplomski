DROP TABLE IF EXISTS my_table;

CREATE TABLE my_table 
(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
,value INT NOT NULL);

INSERT INTO my_table VALUES (1,5),(2,6),(3,6);

SELECT i 
  FROM 
     ( SELECT id
            , CASE WHEN @prev=value THEN @i:='same' ELSE @i:='different' END i
            , @prev:=value prev 
         FROM my_table
            , ( SELECT @prev:=null,@i:=null) vars 
        ORDER 
           BY id 
     ) x 
 ORDER 
    BY id DESC 
 LIMIT 1;
+------+
| i    |
+------+
| same |
+------+