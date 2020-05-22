public interface Worker {

    void work();
}

public abstract class A implements Worker {

    @Override
    public final void work() {
        doPrepare();
        doWork();
    }

    protected abstract void doPrepare();

    protected abstract void doWork();
}

public static class B implements Worker {  // does not extend A, but implements Worker

    private final A wrapped = new A() { // anonymous inner class, so it extends A

        @Override
        protected void doPrepare() {
            System.out.println("doPrepare");
        }

        @Override
        protected void doWork() {
            System.out.println("doWork");
        }
    };

    @Override
    public void work() { // delegate implementation to descendant from A
        this.wrapped.work();
    }
}