SQL> create table t23 as select object_id as id from user_objects;

Table created.

SQL> desc t23
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER

SQL> alter table t23 add hibernate_version_number number default 0 not null;

Table altered.

SQL> desc t23
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER
 HIBERNATE_VERSION_NUMBER                  NOT NULL NUMBER

SQL> select count(*) from t23 where hibernate_version_number = 0;

  COUNT(*)
----------
       504

SQL>