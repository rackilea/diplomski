public class Foo extends Bar implements TestSuite
{
    private static Foo foo;

    @BeforeClass
    public void beforeClass()
    {
        foo = TestSuite.setup();
    }

    @BeforeClass
    public void beforeClass()
    {
        TestSuite.teardown(foo);
    }
}