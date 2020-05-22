@Test
public void testMockitoWithGenerics()
{
    DummyClass dummyClass = Mockito.mock(DummyClass.class);
    List<? extends Number> someList = new ArrayList<Integer>();

    Mockito.doReturn(someList).when(dummyClass).dummyMethod();

    Assert.assertEquals(someList, dummyClass.dummyMethod());
}