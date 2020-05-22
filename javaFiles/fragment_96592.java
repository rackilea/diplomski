private Class<? extends List> implementation = ArrayList.class;

private <E> List<E> newList(Class<E> itemClass) {
    try {
        return (List)implementation.newInstance();
    } catch (Throwable x) {
       return null;
    }
}

@Test
public void test1() {
    List<String> testInstance = newList(String.class);
    testInstance.add('hey');
    assertEquals(3, testInstance.get(0).lenght());
}