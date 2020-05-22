//Sample java code to send email

public void sendEmail(){

        try{

            Properties props = null;

                if (props == null) {
                        props = System.getProperties();
                }

                props.put("mail.smtp.host", "<server host name>");

                Session session = Session.getInstance(props, null);

                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress("<from email id>"));            

                message.addRecipients(Message.RecipientType.CC, "<Registered user email id>");          

                message.setSubject("<Subject of the email>");

                message.setContent("<Content of the email>", "text/plain");         

                Transport.send(message);    

                    logger.info("Sent Email :" + 
                        "From :" + message.getFrom() +
                        "To:" + message.getAllRecipients() +
                        "Subject:" + message.getSubject() );

            } catch(Exception ex){
                ex.printStackTrace();
            }       
        }