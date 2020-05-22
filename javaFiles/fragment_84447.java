FOR each_data IN lock_info
LOOP
 --  put database  lock_info to varchar2 variables "locking_id,waiting_id,status,program_hold,program_wait" --
    FETCH lock_info INTO locking_id,waiting_id,status,program_hold,program_wait;
END LOOP;
CLOSE lock_info;