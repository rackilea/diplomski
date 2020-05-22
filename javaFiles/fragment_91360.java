public static void main(String[] args) throws Exception {
    Request request = Request.classes(new Class<?>[] {Test1.class, Test2.class});

    JUnitCore jUnitCore = new JUnitCore();
    RunListener listener = new RunListener() {

        @Override
        public void testFailure(Failure failure) throws Exception {
            System.out.println("failure=" + failure);
        }

    };
    jUnitCore.addListener(listener);
    jUnitCore.run(request);
}