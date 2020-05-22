CREATE TYPE elem AS OBJECT(ElemID INTEGER);
/

CREATE TYPE list AS TABLE OF elem;
/

CREATE OR REPLACE PROCEDURE work(a OUT VARCHAR2, b OUT SYS_REFCURSOR)
AS
BEGIN
  a := 'test 1234';
  OPEN b FOR
    SELECT 'A' AS col1, 'B' AS col2, list(elem(14), elem(17)) FROM DUAL
     UNION ALL
    SELECT 'C' AS col1, 'D' AS col2, list(elem(8), elem(4), elem(11)) FROM DUAL
     UNION ALL
    SELECT 'E' AS col1, 'F' AS col2, list(elem(-1)) FROM DUAL;
END work;
/