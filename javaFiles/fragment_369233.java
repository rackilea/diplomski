String sql = "update foo set status = 1 where rownr in (select rownr from (select rownr from foo where runid = :runid and status = 0 order by rownr) where rownum = 1)";
return jdbi.withHandle((handle) -> {
  handle
     .createUpdate(sql)
     .bind("runid", runId)
     .executeAndReturnGeneratedKeys("rownr")
     .mapTo(Integer.class)
     .findOnly();
});