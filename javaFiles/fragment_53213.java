private Criterion createKeyValueSqlCriteria(String key, String operator, Object value)
{
    if(operator.equals("like"))
    {
        value = "%" + ((String)value) + "%";
    }
    Object[] valueArray = {key, value};
    Type[] typeArray = {StringType.INSTANCE, getValueType(value)};

    String query = "exists ( select 1 from CONTENT_PROPERTY cp " + 
                   "where cp.FK_CONTENT_ID = {alias}.CONTENT_ID " +
                   "and cp.KEY= ? and cp.VALUE " + operator + " ? )";

    Criterion criterion = Restrictions.sqlRestriction(query,valueArray,typeArray);
    return criterion;
}

private Type getValueType(Object value)
{
    if(value instanceof String)
    {
         return StringType.INSTANCE;
    }
    else if (value instanceof Long)
    {
         return LongType.INSTANCE;
    }
    else if (value instanceof Double)
    {
         return DoubleType.INSTANCE;
    }
    else if (value instanceof Boolean)
    {
         return BooleanType.INSTANCE;
    }
    else if (value instanceof Date)
    {
         return DateType.INSTANCE;
    }
    else
    {
        return null;
    }
}