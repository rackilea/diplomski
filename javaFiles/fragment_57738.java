Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("USERNAME_HERE", "PASSWORD_HERE");
        }
    });