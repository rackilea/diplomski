@Test
public void testVarAnyArg() {
    Collaborator c = mock(Collaborator.class);

    VarargAnyMatcher<String, Integer> matcher = 
            new VarargAnyMatcher<>("b"::equals, 7, 0);
    when(c.f(argThat(matcher))).thenAnswer(matcher);

    assertEquals(7, c.f("a", "b", "c"));
}

private static class VarargAnyMatcher<T, R> implements ArgumentMatcher<T>, VarargMatcher, Answer<R> {
    private final Function<T, Boolean> match;
    private final R success;
    private final R failure;
    private boolean anyMatched = false;

    public VarargAnyMatcher(Function<T, Boolean> match, R success, R failure) {
        this.match = match;
        this.success = success;
        this.failure = failure;
    }

    @Override
    public boolean matches(T t) {
        anyMatched |= match.apply(t);
        return true;
    }

    @Override
    public R answer(InvocationOnMock invocationOnMock) {
        return anyMatched ? success : failure;
    }
}