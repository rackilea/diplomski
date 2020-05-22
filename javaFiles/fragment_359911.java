//Tests what happens when a username is found in the backend
public void testLoginSuccessful() {
    UserService mockUserService = EasyMock.createMock(UserService.class);

    EasyMock.expect(mockUserService.getUser("aUsername")).andReturn(new User(...));
    EasyMock.replay(mockUserService);

    classUnderTest.setUserService(mockUserService);

    boolean isLoggedIn = classUnderTest.login("username");
    assertTrue(isLoggedIn);
}

//Tests what happens when the user does not exist
public void testLoginFailure() {
    UserService mockUserService = EasyMock.createMock(UserService.class);

    EasyMock.expect(mockUserService.getUser("aUsername")).andThrow(new UserNotFoundException());
    EasyMock.replay(mockUserService);

    classUnderTest.setUserService(mockUserService);

    boolean isLoggedIn = classUnderTest.login("username");
    assertFalse(isLoggedIn);
}