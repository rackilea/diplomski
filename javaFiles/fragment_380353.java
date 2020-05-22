JPA.withTransaction(new Callback0() {

    @Override
    public void invoke() throws Throwable {
        ImportCrmData.start();
    }
});