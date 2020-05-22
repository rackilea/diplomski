FSITJA@db01 2019-06-26 14:15:02> select json_object('name'         value username,
  2                     'default_ts'   value default_tablespace,
  3                     'temp_ts'      value temporary_tablespace,
  4                     'common'       value case when common = 'Y' then 'YES' else 'NO' end,
  5                     'oracle_maint' value case when oracle_maintained = 'Y' then 'YES' else 'NO' end
  6                     format json) as json_obj
  7    from dba_users u
  8   where oracle_maintained = 'Y'
  9         and rownum <= 5;

JSON_OBJ
-----------------------------------------------------------------------------------------------------------
{"name":"SYS","default_ts":"SYSTEM","temp_ts":"TEMP","common":"NO","oracle_maint":"YES"}
{"name":"SYSTEM","default_ts":"SYSTEM","temp_ts":"TEMP","common":"NO","oracle_maint":"YES"}
{"name":"GSMCATUSER","default_ts":"SYSTEM","temp_ts":"TEMP","common":"NO","oracle_maint":"YES"}
{"name":"XS$NULL","default_ts":"SYSTEM","temp_ts":"TEMP","common":"NO","oracle_maint":"YES"}
{"name":"MDDATA","default_ts":"SYSTEM","temp_ts":"TEMP","common":"NO","oracle_maint":"YES"}