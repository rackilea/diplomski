declare
  emp_pnum number;
begin
  emp_pnum := 1;
  open :rc for select emp_pnum as emp_pnum from dual;
end;
/

anonymous block completed

print rc

RC
---------------------------------------
EMP_PNUM                                
--------------------------------------- 
1