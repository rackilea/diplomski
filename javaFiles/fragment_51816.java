CREATE OR REPLACE FUNCTION my_function
(p_val IN varchar2)
    RETURN SYS_REFCURSOR
  AS
    my_cursor SYS_REFCURSOR;
  BEGIN
    OPEN my_cursor FOR SELECT emp_name FROM employees
    WHERE lower(emp_name) like lower(p_val||'%');
    RETURN my_cursor;    
  END;