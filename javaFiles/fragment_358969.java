try {
    oAuthClient.accessToken(request);
    fail();
} catch (OAuthProblemException e) {
    //success
}