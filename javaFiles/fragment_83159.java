private static void trace(String format, Object... values)
{
    if (TRACE_LEVEL > LOG_LEVEL)
    {
        return;
    }
    for (int i = 0; i < values.length; i++)
    {
        Object value = values[i];
        if (value instanceof Supplier)
        {
            values[i] = ((Supplier) value).get();
        }
    }
    System.out.println(new MessageFormat(format).format(values));
}