public static InputStream getInputStream(String location) throws IOException {
        URL url = new URL(location);
        URLConnection uc = url.openConnection();
        String username = "";
        String password = "";
        String userpass = username + ":" + password;
        String basicAuth = "Basic "
                + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass
                        .getBytes());
        uc.setRequestProperty("Authorization", basicAuth);
        return uc.getInputStream();
}