props.put("mail.smtp.auth", "true");
.
.
.
Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email+"@"+domain, password);
            }
          });