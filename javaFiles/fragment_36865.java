create table mytable (i int,s string,d date);

insert into mytable values 
    (1,'hello','2017-03-01')
   ,(2,'world','2017-03-02')
;

select * from mytable
;

mytable.i   mytable.s   mytable.d
1   hello   2017-03-01
2   world   2017-03-02

show create table mytable;

CREATE TABLE `mytable`(
  `i` int, 
  `s` string, 
  `d` date)
ROW FORMAT SERDE 
  'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' 
STORED AS INPUTFORMAT 
  'org.apache.hadoop.mapred.TextInputFormat' 
OUTPUTFORMAT 
  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION
  'hdfs://localhost:8020/user/hive/warehouse/mytable'
.
.
.