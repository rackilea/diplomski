DECLARE
   l_curs   SYS_REFCURSOR;
BEGIN
   java_ref_curs_test.get_ref_cursor(l_curs);
   java_ref_curs_test.print_refcursor(l_curs); 
END;