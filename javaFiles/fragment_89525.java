@RunWith(PowerMockRunner.class)
@PrepareForTest({ Foo.class })
public class FooTest
{
    @Test
    public void testToString() throws Exception
    {
        Foo foo = mock(Foo.class);
        when(foo.getBar()).thenReturn(42);
        when(foo.toString()).thenCallRealMethod();
        assertEquals("Bar: 42", foo.toString());
    }
}