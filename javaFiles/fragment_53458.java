UUID uuid = UUID.randomUUID();
    ExtendedPropertyDefinition epd = new ExtendedPropertyDefinition(uuid, "NamaId", MapiPropertyType.String);
    String uuidToStr = uuid.toString();

    String isiEmail     = generateIsiEmail(nmBank, jenis, tglAw, tglAk, produk);
    EmailMessage mail   = new EmailMessage(service);
    mail.setSubject(jdlEmail);
    mail.setBody(new MessageBody(isiEmail)); 

    //set to cc 
    mail.getToRecipients().add(new EmailAddress(from.replaceAll("\\s", "")));                   
    String[] too = to.split("\\;");
    for (int i = 0; i <too.length; i++){
        mail.getToRecipients().add(new EmailAddress(too[i].replaceAll("\\s", "")));                 
    }           
    String[] ccc = cc.split("\\;");
    for (int i = 0; i <ccc.length; i++){
        mail.getCcRecipients().add(new EmailAddress(ccc[i].replaceAll("\\s", "")));
    }           
    mail.setExtendedProperty(epd, "isiId"); 
    mail.sendAndSaveCopy();