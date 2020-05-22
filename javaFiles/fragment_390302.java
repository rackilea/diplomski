MimeMessage message = new MimeMessage(sesion);  
    .
    .
    .
    //Config your message....

    Multipart mp = new MimeMultipart();
    MimeBodyPart htmlPart = new MimeBodyPart();
    htmlPart.setContent("RTF HTML TEXT", "text/html");

    mp.addBodyPart(htmlPart);           
    message.setContent(mp);

    Transport.send(message);