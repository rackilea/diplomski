public boolean sendMail(Map<String, String> info, String template) throws MessagingException, IOException{

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new 
        MimeMessageHelper(mimeMessage,true, "UTF-8"); 

        message.setFrom("sender@example.com");
        message.setTo("mymail@example.com");
        message.setSubject("This is the message subject");

        Context ctx =  new Context(LocaleContextHolder.getLocale());
        ctx.setVariable("info", info);

        try{        
            String messageContent=  engine.process(template, ctx);
            mimeMessage.setContent(tt, "text/html; charset=utf-8");

        }catch(Exception e){
            e.printStackTrace();
        }

        this.mailSender.send(mimeMessage);
        return true;

    }