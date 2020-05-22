public void testxyz(){
    User user1 = createUser("user1", "password", 1L);

    final Y y =  EasyMock.createMock(Y.class);
    final UserDAO userDao = EasyMock.createMock(UserDAO.class);

    final UserServiceImpl userService = new UserServiceImpl(y, userDao);

    EasyMock.expect(y.authenticateUser(user1.getUsername(), user1.getPasswd())).andReturn(true);
    EasyMock.expect(userDao.findByUserName(user1.getUsername())).andReturn(user1);
    assertNotNull("User is null i.e not a valid user",user1);

    EasyMock.replay(y, userDao );
    assertEquals(userService.xyz(user1.getUsername(), user1.getPasswd()), user1);

    EasyMock.verify(y, userDao );
}