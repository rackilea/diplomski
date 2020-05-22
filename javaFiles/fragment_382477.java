-- You would put this in a package, for real code
CREATE OR REPLACE PROCEDURE sync_services IS
BEGIN
  LOCK TABLE so_services IN EXCLUSIVE MODE; 

  -- Note the deltas between the current active services and what we've exported so far
  -- CAVEAT: I am not sweating your exact business logic here.  I am just trying to illustrate the approach.
  -- The logic here assumes that the target database wants only one row for each service_id, so we will send an
  -- "ADD" if the target database should insert a new service ID, "UPDATE", if it should modify an existing service ID,
  -- or "DELETE" if it should delete it.
  -- Also assuming, for "DELETE" command, we only need the service_id, no other fields.
  INSERT INTO so_services_export_cmds
     ( service_id, id_service_provider, cmd, valid_from, valid_to )
  SELECT nvl(so.service_id, soe.service_id) service_id,
         so.id_service_provider id_service_provider,
         CASE WHEN so.service_id IS NOT NULL AND soe.service_id IS NULL THEN 'ADD'
              WHEN so.service_id IS NULL AND soe.service_id IS NOT NULL THEN 'DELETE'
              WHEN so.service_id IS NOT NULL AND soe.service_id IS NOT NULL THEN 'UPDATE'
              ELSE NULL -- this will fail and should.
         END cmd,
         so.valid_from valid_from,
         so.valid_to valid_to
  FROM  ( SELECT * FROM so_services WHERE SYSDATE BETWEEN valid_from AND valid_to ) so
  FULL OUTER JOIN so_services_exported soe ON soe.service_id = so.service_id
  -- Exclude any UPDATES that don't change anything
  WHERE   NOT (     soe.service_id IS NOT NULL 
            AND so.service_id IS NOT NULL 
            AND so.id_service_provider = soe.id_service_provider 
            AND so.valid_from = soe.valid_from 
            AND so.valid_to = soe.valid_to);

  -- Update the snapshot of what the remote database should now look like after processing the above commands.
  -- (i.e., it should have all the current records from the service table)
  DELETE FROM so_services_exported;

  INSERT INTO so_services_exported
     ( service_id, id_service_provider, valid_from, valid_to )
  SELECT service_id, id_service_provider, valid_from, valid_to 
  FROM   so_services so
  WHERE  SYSDATE BETWEEN so.valid_from AND so.valid_to;

  -- For testing (12c only)
  DECLARE
    c SYS_REFCURSOR;
  BEGIN
    OPEN c FOR SELECT * FROM so_services_export_cmds ORDER BY service_id;
    DBMS_SQL.RETURN_RESULT(c);
  END;

  COMMIT;  -- Release exclusive lock on services table
END sync_services;