message.setText("This is actual message");

             Transport transport = session.getTransport("smtp");
                transport.connect( null,smtpUser,smtpPassword); //host, 25, "myemailhere", "mypasshere");
                message.saveChanges();
                transport.sendMessage(message,message.getAllRecipients());

//              Transport.send(message);



             // Send message
            // Transport.send(message);
             System.out.println("Sent message successfully....");