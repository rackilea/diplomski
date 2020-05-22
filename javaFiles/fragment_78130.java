SELECT order_num,TO_CHAR(
     FROM_TZ( CAST( time_Field AS TIMESTAMP ), 'UTC' ) 
     AT LOCAL,
     'YYYY-MM-DD HH:MI:SS PM'
   ) AS local_time
FROM   MY_TABLE
where ord_num='123456789'
ORDER BY time_Field desc;