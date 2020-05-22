CREATE OR REPLACE FUNCTION  auditlogfunc ()
 RETURNS trigger AS
 $body$ 

DECLARE 
  get_last_value integer;
  your_table_name text := 'dv002';
BEGIN

  SELECT id into get_last_value FROM tb_main_table ORDER BY id DESC LIMIT 1;
  EXECUTE format('insert into %s(emp_id, entry_date, name,age) VALUES ($1,$2,$3,$4,$5)', your_table_name) using get_last_value,new.id,current_timestamp,  new.name, new.age;

 RETURN new;
 $body$
 LANGUAGE plpgsql;