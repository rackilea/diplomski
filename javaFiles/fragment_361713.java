public static ResultSet initMock(Object[][] data) throws SQLException {
    final StubResultSetContents contents = new StubResultSetContents(data);
    ResultSet rs = mock(ResultSet.class, RETURNS_SMART_NULLS);
    when(rs.getObject(anyInt())).thenAnswer(new Answer<Object>() {
        public Object answer(InvocationOnMock invocation) throws Throwable {
            return contents.getObject(getIntArgument(invocation));
        }
    });
    // a bunch of similar when(...).thenAnswer(...) constructs...
}