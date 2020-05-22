Podio.client.authenticateWithUserCredentials(usr, pwd)
    .withSessionListener(new SessionListener() {

        @Override
        public boolean onSessionChanged(String authToken, String refreshToken, long expires) {
            // Yeay!
            return false;
        }

    });