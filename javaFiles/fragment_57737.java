//To use TLS
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");

//To use SSL
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "465");