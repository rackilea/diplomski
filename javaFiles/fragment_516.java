CREATE OR REPLACE FUNCTION xxpay_csv_at(
  s varchar2,
  i number
) RETURN VARCHAR2 DETERMINISTIC
IS
BEGIN
  RETURN REGEXP_SUBSTR(
    s,
    '(^|,)(([^,"]*".*?")*[^,"]*)',
    1,
    i,
    NULL,
    2
  );
END;
/