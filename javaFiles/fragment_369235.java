String sql = "update foo set status = 1 where rownr in (select rownr from (select rownr from foo where runid = ? and status = 0 order by rownr) where rownum = 1) returning rownr into ?";
return jdbi.withHandle((handle) -> {
  handle
     .createUpdate(sql)
     .bind(0, runId)
     .addCustomizer(OracleReturning.returnParameters().register(1, OracleTypes.INTEGER))
     .execute(OracleReturning.returningDml())
     .mapTo(Integer.class)
     .findOnly();
});