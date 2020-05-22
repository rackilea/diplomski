Query query = session.createSQLQuery("SELECT STATUS FROM STATUS_TABLE WHERE STATE_ID = :param1");
query.setInt("param1", id);
query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
List statusRes = query.list();
if (statusRes != null) {
    for (Object object : statusRes) {
        Map row = (Map)object;
        java.sql.Clob clobValue = (java.sql.Clob) row.get("STATUS");
        status = clobValue.getSubString(1, (int) clobValue.length());
        log.info("Status->:" + status.toString());
    }
}