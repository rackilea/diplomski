aploetz@cqlsh:stackoverflow2> CREATE TABLE maptest 
    (key text PRIMARY KEY, values map<text,text>);
aploetz@cqlsh:stackoverflow2> INSERT INTO maptest (key, values) 
    VALUES ('key1',{'4':'Four','1':'One','2':'Two'});
aploetz@cqlsh:stackoverflow2> SELECT * FROM maptest ;

 key  | values
------+---------------------------------------
 key1 | {'1': 'One', '2': 'Two', '4': 'Four'}

(1 rows)