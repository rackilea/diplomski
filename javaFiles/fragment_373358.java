CREATE OR REPLACE FUNCTION f_foo(_folder_id int)
  RETURNS TABLE (folder_id int, name text) AS
$func$
BEGIN

RETURN QUERY
SELECT f.folder_id, f.name
FROM   folders f
WHERE  f.folder_id = $1;

IF NOT FOUND THEN       -- only if nothing was found
    RETURN QUERY
    VALUES ($1, NULL);  -- columns must match!
END IF;

END
$func$ LANGUAGE plpgsql STABLE;