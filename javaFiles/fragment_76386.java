create or replace type aq_event_obj as object
(
  id       varchar2(100),
  payload  BLOB
);
commit;