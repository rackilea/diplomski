public class FooTest
{
    @SuppressWarnings( "serial" )
    private class TestException extends RuntimeException
    {}

    @Test
    public void loop3ShouldIncrementCounterBy3() throws Exception
    {
        Bar bar = mock( Bar.class );
        Foo cut = new Foo( bar );

        doNothing().doNothing().doThrow( new TestException() ).when( bar ).doSomething();

        try
        {
            cut.loop();
        }
        catch ( TestException e )
        {}

        assertThat( cut.getCounter(), is( 3 ) );
    }
}