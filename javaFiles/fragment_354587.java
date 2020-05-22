@TestConfiguration
public class TestConfigForMail {

  @Bean
  public JavaMailSender mailSender() {
    final JavaMailSenderImpl sender = new MockMailSender();
    return sender;
  }

  private class MockMailSender extends JavaMailSenderImpl {
    @Override
    public void send(final MimeMessagePreparator mimeMessagePreparator) throws MailException {
      final MimeMessage mimeMessage = createMimeMessage();
      try {
        mimeMessagePreparator.prepare(mimeMessage);
        final String content = (String) mimeMessage.getContent();
        final Properties javaMailProperties = getJavaMailProperties();
        javaMailProperties.setProperty("mailContent", content);
      } catch (final Exception e) {
        throw new MailPreparationException(e);
      }
    }
  }
}