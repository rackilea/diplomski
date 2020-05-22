public Session getMailSession(){
  Properties props = new Properties();
  props.put("mail.transport.protocol", "smtp");
  props.put("mail.smtp.provider.class", CustomTransport.class.getName());
  props.put("mail.smtp.provider.vendor", "foo");
  props.put("mail.smtp.provider.version", "0.0.0");

  return Session.getInstance(props);
}