public class CheckingMail {
     public static void main(String[] args) {
           String host = "mycompanyname.com";
           String mailStoreType = "pop3";
           String username = "myemailid.com"; 
           String password = "mypassword";
           check(host, mailStoreType, username, password);
      }

    public static void check(String host, String mailStoreType,String username, String password) {
    try {
         System.out.println("\n\n1 creating the properties field");
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);   //The POP3 server to connect to.
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");

            Session emailSession = Session.getInstance(properties);
            System.out.println("\n\n2 Get a Session="+emailSession);
            System.out.println("\n\n3 create the POP3 store object and connect with the pop server");

            Store store = emailSession.getStore("pop3s");
            store.connect(host,username,password);
            System.out.println("\n\n4create the folder object and open it");
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            System.out.println("\n\n5 retrieve the messages from the folder in an array and print it");
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
            System.out.println("\n before for loop");
            for (int i = 0, n = messages.length; i < n; i++) {
               Message message = messages[i];
               System.out.println("Email Number =" + (i + 1));
               System.out.println("Subject = " + message.getSubject());
               System.out.println("From =" + message.getFrom()[0]);
               Address[] address;
               StringBuffer msg_buffer_to = new StringBuffer(50);

         if ((address = message.getRecipients(Message.RecipientType.TO)) != null) {
          for (int j = 0; j < address.length; j++) {
           msg_buffer_to.append(address[j]);
           System.out.println("\t\t\tTO " + address[j]);
          }
         }
         StringBuffer msg_buffer_cc = new StringBuffer(50);
         if ((address = message.getRecipients(Message.RecipientType.CC)) != null) {
          for (int j = 0; j < address.length; j++) {
           msg_buffer_cc.append(address[j]);
           System.out.println("\t\t\tCC " + address[j]);
          }
         }
        System.out.println("\n\n\t total length is== "+(msg_buffer_to.length()+msg_buffer_cc.length())+"\n\n");

         if((msg_buffer_to.length()+msg_buffer_cc.length())>100)
         {
          System.out.println("\n\t Address length crossed the limits\t\n");
               properties.put("mail.store.protocol", "pop3");
               properties.put("mail.pop3s.host", "mycompanyname.com");
               properties.put("mail.pop3s.port", "995");
               properties.put("mail.pop3.starttls.enable", "true");
               properties.put("mail.smtp.auth", "true"); 
               properties.put("smtp.starttls.enable", "true");
               properties.put("mail.smtp.host", "mycompanyname.com");
               properties.put("mail.smtp.port", "25");
              Session session = Session.getInstance(properties,new javax.mail.Authenticator() {  
               protected PasswordAuthentication getPasswordAuthentication() {  
                   return new PasswordAuthentication("mymailid.com","mypassword");  
               }  
             });
           try{
                 Folder folder = store.getFolder("inbox");
                 folder.open(Folder.READ_ONLY);
                 if (messages.length != 0) {
                    String from = InternetAddress.toString(message.getRecipients(Message.RecipientType.TO));
                    if (from != null) {
                        System.out.println("From:"  + from);
                    }

                    String to = InternetAddress.toString(message.getRecipients(Message.RecipientType.TO));
                    if (to != null) {
                       System.out.println("To: " + to);             
                    }
                    String subject = message.getSubject();
                    if (subject != null) {
                       System.out.println("Subject: " + subject);
                    }
                       Message forward = new MimeMessage(session);
                       forward.setRecipients(Message.RecipientType.TO,InternetAddress.parse("mymailid.com"));
                       forward.setSubject("Fwd: " + message.getSubject());
                       forward.addFrom(InternetAddress.parse(from));
                       forward.setFrom(new InternetAddress("mymailid.com"));      
                       MimeBodyPart messageBodyPart = new MimeBodyPart();
                       Multipart multipart = new MimeMultipart();
                       messageBodyPart.setContent(message.getContent(), "message/rfc822");
                       multipart.addBodyPart(messageBodyPart);
                       forward.setContent(multipart);
                       forward.saveChanges();
                       Transport.send(forward);
                       System.out.println("message forwarded successfully....");
                      }
             catch(Exception e) {
               e.printStackTrace();  
         }
         }
             }

            System.out.println("\n\n6 close the store and folder objects");    
            emailFolder.close(false);
            store.close();
            } catch (MessagingException e){
               e.printStackTrace();
            } catch (Exception e){
               e.printStackTrace();
            }
     }
     }