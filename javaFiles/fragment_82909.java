private static void setProxy(String proxyHostName, int proxyport, String username, String password){
    setProxy(proxyHostName,proxyport);
    if (username!=null && password!=null) {
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        Authenticator authenticator = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(username, password.toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
    }
}