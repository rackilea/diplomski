OPEN lock_info;
LOOP
   FETCH lock_info INTO locking_id,waiting_id,status,program_hold,program_wait;
   EXIT WHEN lock_info%NOTFOUND;

   -- Process fetched data here

END LOOP;
CLOSE lock_info;