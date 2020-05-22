public class CustomRunAfters extends Statement {

    private final Statement fNext;

    private final Object fTarget;

    private final List<FrameworkMethod> fAfters;

    public CustomRunAfters(Statement next, List<FrameworkMethod> afters, Object target) {
        fNext = next;
        fAfters = afters;
        fTarget = target;
    }

    @Override
    public void evaluate() throws Throwable {
        List<Throwable> fErrors = new ArrayList<Throwable>();
        fErrors.clear();
        try {
            fNext.evaluate();
        } catch (Throwable e) {
            fErrors.add(e);
        } finally {
            beforeRunAfters();
            for (FrameworkMethod each : fAfters) {
                try {
                    each.invokeExplosively(fTarget);
                } catch (Throwable e) {
                    fErrors.add(e);
                }
            }
            afterRunAfters();
        }
        if (fErrors.isEmpty())
            return;
        if (fErrors.size() == 1)
            throw fErrors.get(0);
        throw new MultipleFailureException(fErrors);
    }

    private void afterRunAfters() {
        System.err.println("After running @AfterClass methods");
    }

    private void beforeRunAfters() {
        System.err.println("Before running @AfterClass methods");
    }
}