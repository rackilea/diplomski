select task_id, bind_address, type_id 
From task_pub tp join
     task t   
     on tp.task_id = t.id join
     host h                          
     on t.host_id = h.id   
where h.id = 3 and
      not exists (select 1
                  from task_pub tp2
                  where tp2.task_id = tp.task_id and
                        tp2.host_id = tp.host_id and
                        tp2.type_id < tp.task_id
                 ) ;