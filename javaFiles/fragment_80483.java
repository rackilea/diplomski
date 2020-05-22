private class ProxyAuth extends Authenticator {
    private PasswordAuthentication passwordAuthentication;

    private ProxyAuth(String user, String password) {
        passwordAuthentication = new PasswordAuthentication(user, password.toCharArray())
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return passwordAuthentication;
    }
}