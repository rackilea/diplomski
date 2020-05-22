Answer<Stream> answer = new Answer<Stream>() {
    public Stream answer(InvocationOnMock invocation) throws Throwable {
        return Stream.of("A", "B");
    }
};


when(mock.streamMethod()).thenAnswer(answer);