private void trigger_alter(Connection con, String flag) throws Exception
{
    Query query = new Query(con);
    String selectSql = "select table_owner, trigger_name from user_triggers";

    Statement trgStmt = con.createStatement();

    query.executeQuery(selectSql);
     while(query.next()) {
        int i = 0;
        String table_owner = query.getColValue("table_owner");
        String trigger_name = query.getColValue("trigger_name");
        String triggerSql = "ALTER TRIGGER " + table_owner + "." + trigger_name + " "+ flag  ;
        System.out.println( triggerSql);
        trgStmt.addBatch(triggerSql);
    }

    trgStmt.executeBatch();
    log_obj.FmtAndLogMsg("All triggers have been " + flag+ "D");
}