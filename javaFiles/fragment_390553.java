Object result = session.createSQLQuery(
        "SELECT " +
        "   rownum as id, " +
        "   mm.metric_name, " +
        "   dm.aggregated_value_float, " +
        "   dm.created_timestamp as dm_timestamp, " +
        "   s.type, " +
        "   s.name as subelement_name " +
        "FROM " +
        "   daily_metric dm, " +
        "   subelement s, " +
        "   metric_metadata mm " +
        "WHERE " +
        "   dm.subelement_id =s.subelement_id AND " +
        "   TRUNC(dm.created_timestamp)='15-JAN-15' AND " +
        "   s.subelement_id =1456376 AND " +
        "   dm.metric_metadata_id = mm.metric_metadata_id " +
        "ORDER BY 1,2 DESC")
.addScalar("dm_timestamp", TimestampType.INSTANCE)
.uniqueResult();