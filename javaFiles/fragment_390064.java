public static <T> ReturnContainer test(Class<T> incomingClass)
{
    List<TestTuple<T>> tupelo = new ArrayList<TestTuple<T>>();
    ReturnContainer rc = new ReturnContainer(tupelo, incomingClass);
    return rc;
}