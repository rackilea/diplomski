/**
  * Checks the token to make sure it's still valid. If not, it pops up a dialog asking the user to
  * authenticate.
  */
  private static Token checkToken(String vimeoAPIURL, Token vimeoToken, OAuthService vimeoService) {
    if (vimeoToken == null) {
      vimeoToken = getNewToken(vimeoService);
    } else {
      OAuthRequest request = new OAuthRequest(Verb.GET, vimeoAPIURL);
      request.addQuerystringParameter("method", "vimeo.oauth.checkAccessToken");
      Response response = signAndSendToVimeo(request, "checkAccessToken", true);
      if (response.isSuccessful()
              && (response.getCode() != 200 || response.getBody().contains("<err code=\"302\"")
              || response.getBody().contains("<err code=\"401\""))) {
        vimeoToken = getNewToken(vimeoService);
      }
    }
    return vimeoToken;
  }