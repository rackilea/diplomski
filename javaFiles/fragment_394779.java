Message message = new MimeMessage(session);
        message.setDataHandler(new DataHandler(new ByteArrayDataSource(csv.getBytes("8859_8"),
                "text/csv")));
        message.setFileName("data.csv");
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Query report...");
        Transport.send(message);
        LOG.info("Sent message successfully ...");