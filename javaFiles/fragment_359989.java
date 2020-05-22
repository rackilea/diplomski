CREATE TYPE stringlist AS TABLE OF VARCHAR2(100);
/

CREATE TYPE stringlist_list AS TABLE OF stringlist;
/

CREATE TYPE stringlist_list_list AS TABLE OF stringlist_list;
/

CREATE PROCEDURE load_list (
  in_list IN stringlist_list_list
)
AS
BEGIN
  NULL; -- Do something with the list
END;
/