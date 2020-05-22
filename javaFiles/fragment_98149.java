MimeBodyPart textPart = new MimeBodyPart();
    textPart.setContent(body, "text/html");



    MimeBodyPart attachFilePart = new MimeBodyPart();
    FileDataSource fds = 
        new FileDataSource(file);
    attachFilePart.setDataHandler(new DataHandler(fds));
    attachFilePart.setFileName(fileName);


    Multipart mp = new MimeMultipart();
    mp.addBodyPart(textPart);
    mp.addBodyPart(attachFilePart);