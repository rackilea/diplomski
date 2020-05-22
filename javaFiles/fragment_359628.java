if (params != null && params.size() > 255
     && connection.getPrepareSql() != TdsCore.UNPREPARED
     && procName != null) {
  int limit = 255; // SQL 6.5 and Sybase < 12.50
  if (connection.getServerType() == Driver.SYBASE) {
    if (connection.getDatabaseMajorVersion() > 12 ||
        connection.getDatabaseMajorVersion() == 12 &&
        connection.getDatabaseMinorVersion() >= 50) {
      limit = 2000; // Actually 2048 but allow some head room
    }
  } else {
    if (connection.getDatabaseMajorVersion() == 7) {
      limit = 1000; // Actually 1024
    } else if (connection.getDatabaseMajorVersion() > 7) {
      limit = 2000; // Actually 2100
    }
  }
  if (params.size() > limit) {
   throw new SQLException(
       Messages.get("error.parsesql.toomanyparams",
       Integer.toString(limit)),
       "22025");
  }
}