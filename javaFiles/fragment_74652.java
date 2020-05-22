procedure persist(id_1              out Number,
                  id_2              out Number)
is
   retcode NUMBER := 0;
begin
    retcode := 100;
    /* Checking for semaphore, else wait ! */
    WHILE(retcode = 100)
    LOOP
         retcode = check_semphore(); /* Returns 100 if present else 0 */
         IF(retcode = 100) THEN
           /* Semaphore present */
           NULL;
         ELSE
           write_semaphore;
            /* probably a entry in a table with commit, 
            have to use savepoints, else every other transactions would be comitted! */

           MERGE INTO  middle_table m
           USING (SELECT id_1,id_2 FROM dual) new_Values
             ON ( new_Values.id_1 = m.id_1 
              AND new_Values.id_2 = m.id_2)
           WHEN NOT MATCHED
           THEN
               INSERT INTO middle_table VALUES(id_1,id_2);

          delete_semaphore; 
          /* delete tht entry */

          EXIT;

       END IF;
    END LOOP;
end;
/