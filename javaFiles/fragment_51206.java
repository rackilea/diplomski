Authenticator.setDefault(new Authenticator() {
 @Override
        protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(
   "user", "password".toCharArray());
        }
});