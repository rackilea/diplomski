private static final String SMTP_SERVER = "smtp server";
private static final String USERNAME = "username";
private static final String PASSWORD = "password";

private static final String EMAIL_FROM = "email from";
private static final String EMAIL_TO = "email to";
private static final String EMAIL_TO_CC = "cc";

private static final String EMAIL_SUBJECT = "Subject";

public void sendReplicationCheckResult() {

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty("mail.transport.protocol", "smtp");
    properties.setProperty("mail.smtp.host", SMTP_SERVER);
    properties.setProperty("mail.smtp.port", "25");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.auth", "false");

    // Get the default Session object.
    Session session = Session.getDefaultInstance(properties);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(EMAIL_FROM));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_TO));

        // Set Subject: header field
        message.setSubject(EMAIL_SUBJECT);

        // Create the message part 
        BodyPart messageBodyPart = new MimeBodyPart();

        // Fill the message
//            messageBodyPart.setText("This is message body");
        // Create a multipart message
        Multipart multipart = new MimeMultipart();

        // Set text message part
 //multipart.addBodyPart(messageBodyPart);
        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "File Path";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("File Name");
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);

        // Send message
        SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

        // connect
        t.connect(new SSLSocket(SMTP_SERVER, 25) {
            @Override
            public String[] getSupportedCipherSuites() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String[] getEnabledCipherSuites() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEnabledCipherSuites(String[] strings) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String[] getSupportedProtocols() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String[] getEnabledProtocols() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEnabledProtocols(String[] strings) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public SSLSession getSession() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void addHandshakeCompletedListener(HandshakeCompletedListener hl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeHandshakeCompletedListener(HandshakeCompletedListener hl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void startHandshake() throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setUseClientMode(boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean getUseClientMode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setNeedClientAuth(boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean getNeedClientAuth() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setWantClientAuth(boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean getWantClientAuth() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setEnableSessionCreation(boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean getEnableSessionCreation() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        // send
        t.sendMessage(message, message.getAllRecipients());

        System.out.println("Response: " + t.toString());

        t.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, "Email was sent Successfully"));
    } catch (IOException ex) {
        Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, ex.getLocalizedMessage()));
    } catch (MessagingException ex) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, ex.getLocalizedMessage()));
        Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
    }
}