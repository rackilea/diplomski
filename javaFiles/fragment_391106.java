try{
    // Lookup the user by email
    User user = userDAO.findByEmail(email);

    // If no match we can't authenticate
    if(user == null){
        throw new AuthenticationException();
    }

    // Else, build a token with the user id and password
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserId().toString(), password);

    // Attempt to login
    SecurityUtils.getSubject().login(token);

}catch(AuthenticationException ex){
    return false;
}