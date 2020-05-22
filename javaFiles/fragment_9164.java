select t.column_value as process_id 
      from  table(FUNCTION_1(1)) t

--result
    PROCESS_ID
1   1
2   2


--we need create new type - table of integers
CREATE OR REPLACE TYPE t_process_ids IS TABLE OF int;

--and make changes in function
CREATE OR REPLACE FUNCTION FUNCTION_1(
    c_id IN INT)
  RETURN t_process_ids
AS
  l_ids  t_process_ids := t_process_ids();
BEGIN
  --here I populated result of select into the local variables
  SELECT process.id
  bulk collect into l_ids
  FROM PROCESS
  WHERE process.corporate_id = c_id
  ORDER BY process.corporate_id;

  --return the local var
  return l_ids;
END FUNCTION_1;

--the script that I used for testing
create table process(id int, corporate_id int, date_created date);
insert into process values(1, 1, sysdate);
insert into process values(2, 1, sysdate);
insert into process values(3, 2, sysdate);