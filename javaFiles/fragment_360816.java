@Test
public void test() {
    Object mock = Mockito.mock(Object.class, new NullPointerExceptionAnswer());
    String s = mock.toString(); // Breaks here, as intended.
    assertEquals("", s);
}

class NullPointerExceptionAnswer<T> implements Answer<T> {
    @Override
    public T answer(InvocationOnMock invocation) throws Throwable {
        throw new NullPointerException();
    }
}