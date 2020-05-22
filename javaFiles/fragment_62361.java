@With(SecurityAuthAction.class)
public Result userPrivateProfile(Long id) {

    // We've already established that an auth token header is present in the request
    final String authToken = ctx.request().headers().get(AUTH_TOKEN_HEADER)[0];
    final Long userId = sessionService.findUserByToken(authToken);

    // TODO: Proceed...
}