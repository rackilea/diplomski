SELECT sd.emp_code, COUNT(*) as cnt 
FROM EMPLOYEE e 
WHERE e.VERIFY_STATUS = 1 AND
      e.RELIEF_TYPE IS NULL  AND                                 
      e.emp_code = to_char(sd.emp_code) AND
      e.EMP_TYPE_ID <> 03
GROUP BY sd.emp_code
HAVING COUNT(*) > 1;