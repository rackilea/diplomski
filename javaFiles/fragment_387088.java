@Bean(name = "javaMailSender")
  public JavaMailSender javaMailSender(@Value("${mail.smtp.host}") String smtpHost,
                                       @Value("${mail.smtp.port}") int smtpPort,
                                       @Value("${mail.name}") String mailName,
                                       @Value("${mail.cred}") String mailCred) {
    Properties props = new Properties();
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");

    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setHost(smtpHost);
    javaMailSender.setPort(smtpPort);
    javaMailSender.setUsername(mailName);
    javaMailSender.setPassword(mailCred);
    javaMailSender.setJavaMailProperties(props);
    return javaMailSender;
  }