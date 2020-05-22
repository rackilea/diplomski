aploetz@cqlsh:stackoverflow2> CREATE TABLE listtest 
    (key text PRIMARY KEY, values list<text>);
aploetz@cqlsh:stackoverflow2> INSERT INTO listtest (key, values) 
    VALUES ('key2',['4','1','2']);
aploetz@cqlsh:stackoverflow2> SELECT * FROM listtest ;

 key  | values
------+-----------------
 key2 | ['4', '1', '2']

(1 rows)