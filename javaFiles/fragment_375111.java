Authenticator.setDefault(new Authenticator() {
    private URL previous;
    int count = 0;
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
           try {
               if (previous == getRequestingURL())
                   count++;
               if (previous != getRequestingURL()) {
                   count = 0;
               } else {
                    if (count<3) {
                         // Ask for login/passwd to the user
                    } else {
                        // Throw a RuntimeException to prevent locking the account
                        throw new TooManyFailedAttemptException();
                    }

                   return new PasswordAuthentication("login", "password".toCharArray());
               }
          } finally {
               previous = getRequestingURL();
          }
    }
});