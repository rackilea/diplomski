class Service {

    public void someMethod() {
        Data data = AnotherUtils.getData();

        try {
            Utils.method(data); // exception never thrown
        } catch(Exception e) {
            // how to test this branch?
        }
    }

}