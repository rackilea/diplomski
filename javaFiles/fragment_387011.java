for (Map.Entry<String, List<values>> entry : testMap
            .entrySet()) {
        ...
        mail.sendMail( msgFrom,body); // call my sendMail function in another class
    }
    mail.sendLastMails();