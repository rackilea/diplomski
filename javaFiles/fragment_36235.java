when(userService.save(user)).thenAnswer(new Answer<Long>() {
    @Override
    public Long answer(InvocationOnMock invocation) {
        user.setId(1L);
        return 1L;
    }
});