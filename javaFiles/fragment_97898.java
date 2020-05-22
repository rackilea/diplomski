/**
* Gets authorization URL, pops up a dialog asking the user to authenticate with the url and the user
* returns the authorization code
*
* @param service
* @return
*/
private static Token getNewToken(OAuthService service) {
  // Obtain the Authorization URL
  Token requestToken = service.getRequestToken();
  String authorizationUrl = service.getAuthorizationUrl(requestToken);
  do {
    String code = JOptionPane.showInputDialog("The token for the account (whatever)" + newline
            + "is either not set or is no longer valid." + newline
            + "Please go to the URL below and authorize this application." + newline
            + "Paste the code you're given on top of the URL here and click \'OK\'" + newline
            + "(click the 'x' or input the letter 'q' to cancel." + newline
            + "If you input an invalid code, I'll keep popping up).", authorizationUrl + "&permission=delete");
    if (code == null) {
      return null;
    }
    Verifier verifier = new Verifier(code);
    // Trade the Request Token and Verfier for the Access Token
    System.out.println("Trading the Request Token for an Access Token...");
    try {
      Token token = service.getAccessToken(requestToken, verifier);
      System.out.println(token); //Use this output to copy the token into your code so you don't have to do this over and over.
      return token;
    } catch (OAuthException ex) {
      int choice = JOptionPane.showConfirmDialog(null, "There was an OAuthException" + newline
              + ex + newline
              + "Would you like to try again?", "OAuthException", JOptionPane.YES_NO_OPTION);
      if (choice == JOptionPane.NO_OPTION) {
        break;
      }
    }
  } while (true);
  return null;
}