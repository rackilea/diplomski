public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }


    public void testFoo() {
        Main main = ObjectGraph.create(new ExampleTestModule()).get(Main.class);
        assertNotNull(main.foo);
    }

    public void testFooBar() {
        Main main = ObjectGraph.create(new ExampleTestModule()).get(Main.class);
        assertNotNull(main.foo.bar);
    }
}