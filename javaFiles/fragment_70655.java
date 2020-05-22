public AuthorizationToken createAuthorizationToken(User user) {
    if(user.getAuthorizationToken() == null) {
        LOG.debug("UserToken is null, creating new token");
        user.setAuthorizationToken(new AuthorizationToken(user, applicationConfig.getAuthorizationExpiryTimeInSeconds()));
        userRepository.save(user);
    } else if (user.getAuthorizationToken().hasExpired()) {
        LOG.debug("UserToken has expired, creating new token");
        AuthorizationToken oldToken = user.getAuthorizationToken();
        oldToken.setUser(null);
        tokenRepository.update(oldToken);
        user.setAuthorizationToken(new AuthorizationToken(user, applicationConfig.getAuthorizationExpiryTimeInSeconds()));
        userRepository.save(user);
    }
    return user.getAuthorizationToken();
}