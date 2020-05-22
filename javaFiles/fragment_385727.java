public static <T> T getInstance(Class<T> type) throws Exception
{
    Constructor<T> c = type.getConstructor();
    c.setAccessible(true);
    return c.newInstance();
}