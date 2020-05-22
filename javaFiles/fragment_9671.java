expectPrivate(tested, WebService.class.getDeclaredMethod("runUpdateQuery", String.class, String[].class),
        EasyMock.anyString(), EasyMock.aryEq(params)).andAnswer(new IAnswer<Void>() {
    @Override
    public Void answer() throws Throwable {
        return null;
    }
});