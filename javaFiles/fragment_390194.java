@Test
public void test() {
    Callback callback = Mockito.mock(Callback.class);

    final List<List<String>> listParameters = new ArrayList<List<String>>();
    Mockito.doAnswer(new Answer<Void>() {
        public Void answer(InvocationOnMock invocation) throws Throwable {
            List<String> list = (List<String>) invocation.getArguments()[1];
            listParameters.add(new ArrayList<String>(list));
            return null;
        }
    }).when(callback).foo(Mockito.anyString(), Mockito.anyList());

    {
        List<String> list = new ArrayList<String>(); //note: this List object is inaccessible from the unit test in my real use-case
        callback.foo("name1", list);
        list.add("value");
        callback.foo("name2", list);
    }

    InOrder inOrder = Mockito.inOrder(callback);
    inOrder.verify(callback).foo(Mockito.eq("name1"), Mockito.anyList());
    inOrder.verify(callback).foo(Mockito.eq("name2"), Mockito.anyList());

    Assert.assertEquals(Arrays.asList(
        Arrays.asList(),
        Arrays.asList("value")
    ), listParameters);
}