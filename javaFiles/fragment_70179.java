public class GMTDateTypeHandler implements TypeHandlerCallback
{     
    @Override
    public void setParameter(ParameterSetter setter, Object parameter) 
        throws SQLException
    {
        java.util.Date date = (java.util.Date) parameter;
        if ( date == null )
            setter.setNull(Types.TIMESTAMP);
        else
        {
            Timestamp timestamp = new Timestamp(date.getTime());
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            setter.setTimestamp(timestamp, calendar);
        }
    }

    @Override
    public Object getResult(ResultGetter getter) throws SQLException
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        return getter.getTimestamp(calendar);
    }

    @Override
    public Object valueOf(String s)
    {
        throw new UnsupportedOperationException(
            "GMTDateTypeHandler.valueOf() is not supported.");
    }
}