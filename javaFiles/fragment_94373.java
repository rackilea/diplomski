select *
from   queue_requests
where  request_status = 0 and
       date_requested <= sysdate and
       mod(DBMS_RowID.RowID_Row_Number(queue_requests.rowid),5) = thread_number
       rownum <= ?
for update
skip locked;