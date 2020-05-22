when(rs.next()).thenAnswer(new Answer() {
    private int iterations = 2;

    Object answer(InvocationOnMock invocation) {
        return iterations-- > 0;
    }
});