class Blammy
{
  static final java.sql.Date convertTimestamp(final java.sql.Timestamp timestamp)
  {
    java.sql.Date returnValue;

    if (timestamp != null)
    {
      returnValue = new java.sql.Date(timestamp.getTime());
    }
    else
    {
      returnValue = null; // an exception might be better here.
    }

    return returnValue
  }
}