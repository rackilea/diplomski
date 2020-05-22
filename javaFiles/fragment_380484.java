CREATE OR REPLACE FUNCTION insert_timeout_configuration() RETURNS bigint AS '
  DECLARE created_id bigint;

  BEGIN
    INSERT INTO timeout_configuration (id, version, timeout)
    VALUES (nextval(''my_sequence''), 0, 300)
    RETURNING id INTO created_id;
    return created_id;
  END;
' language plpgsql;

CREATE OR REPLACE FUNCTION insert_url_configuration() RETURNS bigint AS '
  DECLARE created_id bigint;

  BEGIN
    INSERT INTO url_configuration (id, version, my_url)
    VALUES (nextval(''my_sequence''), 0,''http://localhost:8080/'')
    RETURNING id INTO created_id;
    return created_id;
  END;
' language plpgsql;

DO '
      INSERT INTO global_configuration(id, version, name, timeout_configuration_id, url_configuration_id)
      VALUES (nextval(''my_sequence''), 0, ''My global config'', insert_timeout_configuration(), insert_url_configuration());

-- do some other code 
END
';
drop function insert_timeout_configuration();
drop function insert_url_configuration();