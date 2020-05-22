public class A extends B {

    private boolean workDone = false;

    @Override
    public void publicMethod(final boolean flag) {
        if (!workDone) {
            privateMethod();
            workDone = true;
        }
        callParentPublicMethod(flag);
    }

    private void callParentPublicMethod(final boolean flag) {
        super.publicMethod(flag);
    }

    private void privateMethod() {
        System.out.println("A: privateMethodCalled");
    }
}