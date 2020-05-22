Session session = Session.getInstance(props, new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(“username”, “password”);
    }
}

/*
 * no need to pass protocol to getTransport()
 * no need to pass username and password to connect() 
 * if credentials were incorrect, you would get a corresponding error
 */
session.getTransport().connect();



// no need to use instance, we simply use static method
Transport.send(message);