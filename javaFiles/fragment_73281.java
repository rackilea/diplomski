final String authUser = "user";
final String authPassword = "password";
Authenticator.setDefault(
  new Authenticator() {
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(authUser, authPassword.toCharArray());
    }
  }
);

System.setProperty("http.proxyUser", authUser);
System.setProperty("http.proxyPassword", authPassword);

System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");