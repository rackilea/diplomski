@Test
public void test1() {
     int[] number = { 0 };
     Simple simple = Mockito.mock(Simple.class);
     Mockito.doAnswer(new Answer<Void>() {
        @Override
        public Void answer(InvocationOnMock invocation) throws Throwable {
            number[0]++;
            return null;
        }
    }).when(simple).doSomething();
}