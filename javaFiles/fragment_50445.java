declare
  d DATE;

  FUNCTION createUnvalidatedDate(
    centuries INT := 0,
    years     INT := 0,
    months    INT := 0,
    days      INT := 0,
    hours     INT := 0,
    minutes   INT := 0,
    seconds   INT := 0
  ) RETURN DATE
  IS
    dt         DATE;
    hex_string CHAR(14);
  BEGIN
    hex_string := LPAD( TO_CHAR( centuries + 100, 'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( years + 100,     'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( months,          'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( days,            'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( hours + 1,       'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( minutes + 1,     'fmXX' ), 2, '0' )
               || LPAD( TO_CHAR( seconds + 1,     'fmXX' ), 2, '0' );
    dbms_stats.convert_raw_value(hextoraw(hex_string), dt);
    RETURN dt;
  END;
begin
  d := createUnvalidatedDate( 19, 0, 5, 127, 126, 118, 87 );
  INSERT INTO Dates ( d ) VALUES ( d );
  d := createUnvalidatedDate( 0, 0, 0, 0, 0, 0, 0 );
  INSERT INTO Dates ( d ) VALUES ( d );
  d := createUnvalidatedDate( 20, 19, 6, 24, 10, 28, 30 );
  INSERT INTO Dates ( d ) VALUES ( d );
end;
/