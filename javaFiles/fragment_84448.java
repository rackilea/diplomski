FOR each_data IN lock_info
LOOP
--    FETCH lock_info INTO locking_id,waiting_id,status,program_hold,program_wait;
     locking_id := each_data.locking_id;
     waiting_id := each_data.waiting_id;
     status := each_data.status;
     program_hold := each_data.program_hold;
     program_wait := each_data.program_wait;

     -- Process fetched data here

END LOOP;
-- CLOSE lock_info;