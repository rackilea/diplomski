BodyPart messageBodyPart = new MimeBodyPart();
                // Fill the message
                messageBodyPart.setContent("<h1>You Have a Promotion</h1> <h3>Your First Name :</h3>" + FirstNm + 
                          "<h3>Your Last Name :</h3>" + LastNm + "<h5>Your Employee ID :</h5>" + Employeeid ,"text/html");
                // Create a multipar message
                Multipart multipart = new MimeMultipart();
                // Set text message part
                multipart.addBodyPart(messageBodyPart);

                // Part two is attachment
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource("");//add file path
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName("");//file name to be displayed
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);