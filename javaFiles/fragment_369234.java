String sql = "declare\n" + 
     "vRownr foo.rownr%type;\n" + 
     "begin\n" + 
     "update foo set status = 1 where rownr in (select rownr from (select rownr from foo where runid = :runid and status = 0 order by rownr) where rownum = 1) returning rownr into vRownr;\n" + 
     ":rownr := vRownr;\n" + 
     "end;";
return jdbi.withHandle((handle) -> {
  OutParameters params = handle
     .createCall(sql)
     .bind("runid", runId)
     .registerOutParameter("rownr", Types.INTEGER)
     .invoke();
  return params.getInt("rownr");
});