for (int i = 0; i < list.size(); i++) { 
        ...
        MailSenderInfo mailSenderInfo2 = new MailSenderInfo();
        mailSenderInfo2 = mailSenderInfo; // remove this
        mailSenderInfo2.setAddress(address);
        queue.offer(mailSenderInfo2);
    }