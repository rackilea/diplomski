context.checking(new Expectations() {
    protected void buildExpectations() {
        allowing(csv).getFileName();
        will(returnValue(fileName));
    }
});