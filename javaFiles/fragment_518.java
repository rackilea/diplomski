CREATE OR REPLACE FUNCTION xxpay_csv_at(
  s varchar2,
  i number,
  delim VARCHAR2 DEFAULT ','
) RETURN VARCHAR2 DETERMINISTIC
IS
  j    PLS_INTEGER := 1;
  curr PLS_INTEGER := 1;
  dpos PLS_INTEGER;
  qpos PLS_INTEGER;
BEGIN
  WHILE TRUE LOOP
    dpos := INSTR( s, delim, curr );
    qpos := INSTR( s, '"', curr ); -- Start quote
    WHILE qpos BETWEEN curr AND dpos LOOP
      qpos := INSTR( s, '"', qpos + 1 ); -- End quote
      IF qpos = 0 THEN
        RAISE_APPLICATION_ERROR( -20000, 'Invalid String - No matching end-quote' );
      END IF;
      dpos := INSTR( s, delim, qpos + 1 );
      qpos := INSTR( s, '"', qpos + 1 );
    END LOOP;

    IF dpos = 0 THEN
      IF i = j THEN
        RETURN SUBSTR( s, curr );
      ELSE
        RETURN NULL;
      END IF;
    ELSE
      IF i = j THEN
        RETURN SUBSTR( s, curr, dpos - curr );
      ELSE
        j := j + 1;
        curr := dpos + LENGTH( delim );
      END IF;
    END IF;
  END LOOP;
END;
/