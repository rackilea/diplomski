private static class ReturnInterfaceImpl implements ReturnInterface<String>  {

};

public void foo() {
    Callable<ReturnInterfaceImpl> c = new Callable<ReturnInterfaceImpl>() {
        @Override
        public ReturnInterfaceImpl call() throws Exception {
            return null;
        }
    };
    submitCallable(c);
}