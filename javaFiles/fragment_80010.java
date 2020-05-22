public static String getAccessToken(String uriString) {
    URI uri = URI.create(uriString);
    String[] parameters = uri.getFragment().split("\\&");
    for (String parameter : parameters) {
        String[] parts = parameter.split("\\=");
        if (parts[0].equals("access_token")) {
            if (parts.length == 1) {
                throw new RuntimeException("missing access token");
            }
            return parts[1];
        }
    }
    throw new RuntimeException("no access token");
}