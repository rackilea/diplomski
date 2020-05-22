String filePath = "/tmp/dummy.txt"
     MimeBodyPart bodyPart = new MimeBodyPart();
     DataSource source = new FileDataSource(filePath);
     bodyPart.setDataHandler(new DataHandler(source));
     bodyPart.setFileName(fileName);
     multipart.addBodyPart(bodyPart);