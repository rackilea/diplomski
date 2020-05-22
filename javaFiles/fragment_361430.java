SET serveroutput ON;
DECLARE
  lvtab lv_tab;
BEGIN
  EXECUTE IMMEDIATE 'SELECT test_obj(LEVEL,LEVEL+1) FROM DUAL CONNECT BY LEVEL < 10' BULK COLLECT INTO lvtab;
  dbms_output.put_line(lvtab.COUNT);
END;