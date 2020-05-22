create or replace type queue_record as object (
  id number(10),
  add_date date
);

create or replace type my_queue_type as table of queue_record;

create or replace procedure pull_from_queue (
  pull_size in number,
  pulled_records out sys_refcursor
)
is
  tbl my_queue_type;
begin

  delete from my_queue
  where id in (
    select id from ( select * from my_queue order by add_date )
    where rownum <= pull_size
  )
  returning queue_record(id, add_date)
  bulk collect into tbl;

  open pulled_records for
  select * from table(cast(tbl as my_queue_type)) order by add_date;

end pull_from_queue;