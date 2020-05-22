Session session = javax.mail.Session.getInstance( props, 
         new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
               return new javax.mail.PasswordAuthentication("username", "password"); //username and password
       }
         });