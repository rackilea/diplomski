if(Assets.HTTP_USE_PROXY) {
        System.setProperty("proxySet", "true");
        System.setProperty("https.proxyHost", Assets.HTTP_PROXY_HOST);
        System.setProperty("https.proxyPort", Integer.toString(Assets.HTTP_PROXY_PORT));
        if(Assets.HTTP_REQUIRE_AUTH) {
            System.setProperty("https.proxyUser", Assets.HTTP_PROXY_USER);
            System.setProperty("https.proxyPassword", Assets.HTTP_PROXY_PASSWORD);
            Authenticator.setDefault(
                      new Authenticator() {
                        public PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(Assets.HTTP_PROXY_USER, 
                                  Assets.HTTP_PROXY_PASSWORD.toCharArray());
                        }
                      }
                    );
        }
    }