CREATE OR REPLACE FUNCTION sample(description varchar, name varchar)
RETURNS integer LANGUAGE 'plpgsql' AS ' DECLARE
  BEGIN
  select * from "RESULT";
  RETURN 1;
END; ';