dbRequest.setPreparedStatement("SELECT "
+ " COUNT(*) \"All\","
+ " COUNT(CASE WHEN TYPE = 'Critical' THEN 1 END) \"Critical\", "
+ " COUNT(CASE WHEN TYPE = 'Info' THEN 1 END) \"Info\", "
+ " COUNT(CASE WHEN TYPE = 'Warning' THEN 1 END) \"Warning\", "
+ " COUNT(CASE WHEN TYPE = 'Error' THEN 1 END) \"Error\" "
+ " FROM "
+ " EVENT");