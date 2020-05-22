class C2 {
    public interface SomeOtherListener extends SomeListener {
        public void interfaceMethod();
    }

    public static void doAddListener(SomeOtherListener listener) {
        C1.addSomeListener(listener);
    }
 }