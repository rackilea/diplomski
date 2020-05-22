static {

    java.net.Authenticator.setDefault(new java.net.Authenticator() {

        @Override
        protected java.net.PasswordAuthentication getPasswordAuthentication() {
            return new java.net.PasswordAuthentication("myuser", "mypasswd".toCharArray());
        }
    });
}