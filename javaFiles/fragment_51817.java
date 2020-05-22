CREATE OR REPLACE PROCEDURE myProcedure(p_cursor out sys_refcursor,
     p_val  in varchar2
)
 AS
BEGIN
     OPEN o_cursor FOR
          SELECT     emp_name 
             FROM     employees 
            WHERE     LOWER (emp_name) LIKE lower(p_val||'%');