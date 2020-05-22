create or replace
FUNCTION check_id(ID_INPUT IN VARCHAR2) 
   RETURN NUMBER
   IS count_id NUMBER;
Begin 
   SELECT count(*) INTO count_id FROM table WHERE UPPER(ID_INPUT) = UPPER(ID); 
   Return(Count_Id); 
END;