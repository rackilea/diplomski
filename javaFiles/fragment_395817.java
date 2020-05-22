arecords = LOAD '$a'  USING PigStorage('^')  as (token:chararray, type:chararray);

brecords =  LOAD '$b'  USING PigStorage('^')  as (token:chararray, name:chararray);

bdistinct = DISTINCT brecords;

x = JOIN arecords BY token, bdistinct BY token;

dump x;