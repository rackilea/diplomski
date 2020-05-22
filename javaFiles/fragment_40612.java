sendMail.setTo((List<String>) args[2]);
        sendMail.setSubject(args[3].toString());
        sendMail.setBody(args[4].toString());
        //sendMail.addAttachment(args[5].toString());  <- Error here 
        publishProgress("Sending email....");
        sendMail.send();

          :