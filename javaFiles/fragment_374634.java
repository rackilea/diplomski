@Test
public void signUp_shouldCheckIfUserExistsBeforeSign() throws ServiceException {

    // GIVEN
    User user = new User();
    user.setEmail(EMAIL);
    when(usersRepository.exists(EMAIL)).thenReturn(Boolean.TRUE);

    // WHEN 
    try {
        usersService.signUp(user);

    // THEN
        // expecting exception - should jump to catch block, skipping the line below:
        Assert.fail("Should have thrown UserAlreadyExistsServiceException");         
    }catch(UserAlreadyExistsServiceException e) {
        // expected exception, so no failure
    }
    // other post-sign-up validation here
}