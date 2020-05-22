create procedure proc1(
IN in_val
)
language sql
dynamic result sets 1

BEGIN
-- do insert

BEGIN
DECLARE c_out CURSOR WITH RETURN TO CLIENT FOR
  select max(key) as inserted_key from table where val = in_val
FOR READ ONLY;

OPEN c_out;
END;

END;