create or replace function foo_cursor(name character varying)
returns refcursor
as $func$
declare
  ref refcursor;
begin
  open ref for
    select id, first_name, last_name
    from students
    where first_name = name;
  return ref;
end
$func$ 
language plpgsql;