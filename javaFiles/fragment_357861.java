public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("youremailaddress@gmail.com");
        javaMailSender.setPassword("GMAIL PASSWORD HERE");

        javaMailSender.setJavaMailProperties(getMailProperties());
        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"));
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "false");
        return properties;
    }

    JavaMailSender javaMailSender = getJavaMailSender();

    private void sendEmail(){
        javaMailSender.send((MimeMessage mimeMessage) -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom("from@no-spam.com");
            message.setTo("to@no-spam.com");
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," +
                "\n\n No spam to my email, please!");
        });
    }