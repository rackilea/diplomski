public class ExecutionTest {
    public class BeforeExecution implements TestRule {
        public Statement apply(Statement base, Description description) {
            return statement(base, description);
        }

        private Statement statement(final Statement base, final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    if (description.getAnnotation(Deprecated.class) != null) {
                        // you can do whatever you like here.
                        System.err.println("this will be run when the method has an @Deprecated annotation");
                    }
                    base.evaluate();
                }
            };
        }
    }

    @Rule public BeforeExecution beforeExecution = new BeforeExecution();

    // Will have code executed.
    @Deprecated
    @Test public void test1() {
         // stuff
    }

    // won't have code executed.
    @Test public void test2() {
         // stuff
    }
}