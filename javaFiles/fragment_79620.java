try {
    Connection connection = client.connect(serverName);
    this.connection = connection; // save the connection reference to be able to close it later manually
    AuthenticationContext ac = new AuthenticationContext(username, password.toCharArray(), domain);
    Session session = connection.authenticate(ac);
    this.session = session;
    return session;
} catch (IOException e) {
    e.printStackTrace();
}