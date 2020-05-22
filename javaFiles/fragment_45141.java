CREATE table test (partition int, clustering text, amount double, PRIMARY KEY (partition, clustering));
INSERT INTO test (partition , clustering, amount) VALUES ( 1, '2015', 99.1);
INSERT INTO test (partition , clustering, amount) VALUES ( 1, '2016', 18.12);
INSERT INTO test (partition , clustering, amount) VALUES ( 1, '2017', 44.889);
SELECT * from test;

 partition | clustering | amount
-----------+------------+--------
         1 |       2015 |   99.1
         1 |       2016 |  18.12
         1 |       2017 | 44.889