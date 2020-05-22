public class EDTRule implements TestRule {

    @Override
    public Statement apply(Statement stmt, Description dscr) {
        return new Statement() {
            private Throwable ex;

            @Override
            public void evaluate() throws Throwable {
                SwingUtilities.invokeAndWait(() -> {
                    try {
                        stmt.evaluate();
                    } catch (Throwable t) {
                        ex = t;
                    }
                });
                if (ex != null) {
                    throw ex;
                }
            }
        };
    }
}