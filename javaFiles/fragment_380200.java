MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            FileSystemResource file = new FileSystemResource(new File("c:\\simple.jpg"));
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.addRecipient(Message.RecipientType.TO, new InternetAddress(clientEmail));
                helper.setFrom("xyz@gmail.com");
                helper.setText(
                        "Hi");
                helper.addAttachment(file.getFilename(), file);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            try {
                this.javaMailSender.send(mimeMessage);
            } catch (MailException ex) {
                // simply log it and go on...
                System.err.println(ex.getMessage());
            }