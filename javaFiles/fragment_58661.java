when(myOperation.getSomething(any(String.class))).thenAnswer(new Answer<SomeThing>() {
    @Override
    public SomeThing answer(final InvocationOnMock invocation) throws Throwable {
        // HERE ====> use invocation.getArguments()
        return new SomeThing();
    }
});