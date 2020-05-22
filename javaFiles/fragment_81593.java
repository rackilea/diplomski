SELECT
t2.client_id,
t2.object_key,
t2.prio,
t2.dense_rank
FROM
    (SELECT 
          t1.*,
          @dense:=IF(@prev_client_id=t1.client_id AND @prev_prio=t1.prio, @dense+1, 1) AS dense_rank,
          @prev_client_id:=t1.client_id,
          @prev_prio:=t1.prio
        FROM (select * from clients c1 order by prio, client_id) t1,
             (SELECT @dense:=0, @prev_client_id:=NULL, @prev_prio:=NULL) var1
    ) t2;