1  CREATE OR REPLACE PROCEDURE LIVE
  2  AS
  3    v_ename scott.emp.ename%type;
  4  begin
  5    select ename
  6      from scott.emp
  7      where empno = 7369;
  8* end;
SQL> /

Warning: Procedure created with compilation errors.

SQL> show errors
Errors for PROCEDURE LIVE:

LINE/COL ERROR
-------- -----------------------------------------------------------------
5/3      PLS-00428: an INTO clause is expected in this SELECT statement

  1  CREATE OR REPLACE PROCEDURE LIVE
  2  AS
  3    v_ename scott.emp.ename%type;
  4  begin
  5    select ename
  6      into v_ename
  7      from scott.emp
  8      where empno = 7369;
  9* end;
SQL> /

Procedure created.