doAnswer(new Answer() {
    public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        List<?> list = (List<?>) args[0];
        list.clear();
        return null;
    }
}).when(test).clearList(any(List.class));