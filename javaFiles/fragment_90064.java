SQL> CREATE OR REPLACE TYPE IDS AS OBJECT ( id1 NUMBER, id2 NUMBER, id3 NUMBER );
  2  /
Type created

SQL> CREATE OR REPLACE TYPE IDS_TABLE AS TABLE OF IDS;
  2  /
Type created

SQL> CREATE OR REPLACE PROCEDURE getInfo(p_ids IN IDS_TABLE) IS
  2  BEGIN
  3     FOR i IN 1 .. p_ids.COUNT LOOP
  4        dbms_output.put_line(p_ids(i).id1
  5                             || ',' || p_ids(i).id2
  6                             || ',' || p_ids(i).id3);
  7     END LOOP;
  8  END getInfo;
  9  /     
Procedure created