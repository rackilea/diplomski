SQL> CREATE OR REPLACE PROCEDURE parse(p_command VARCHAR2) AUTHID CURRENT_USER IS
  2     l_cursor INTEGER;
  3  BEGIN
  4     l_cursor := dbms_sql.open_cursor;
  5     dbms_sql.parse(l_cursor, p_command, dbms_sql.native);
  6     dbms_sql.close_cursor(l_cursor);
  7  EXCEPTION
  8     WHEN OTHERS THEN
  9        dbms_sql.close_cursor(l_cursor);
 10        RAISE;
 11  END;
 12  /

Procedure created

SQL> exec parse ('BEGIN NULL;END;');

PL/SQL procedure successfully completed

SQL> exec parse ('BEGIN incorrect_statement;END;');

begin parse ('BEGIN incorrect_statement;END;'); end;

ERROR at line 1:
ORA-06550: line 1, column 7:
PLS-00201: identifier 'INCORRECT_STATEMENT' must be declared