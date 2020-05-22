public static <T> ReturnContainer<T> test(Class<T> incomingClass)
{
    List<TestTuple<T>> tupelo = new ArrayList<TestTuple<T>>();
    ReturnContainer rc = new ReturnContainer<T>(tupelo, incomingClass);
    return rc;
}