case CHARACTER: {
  ...many other conversions...
  switch (ssType) {
    case DATETIME: // and SMALLDATETIME
    {
      return (new java.sql.Timestamp(cal.getTimeInMillis())).toString();
    }