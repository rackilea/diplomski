public class MultipartSignedDetector implements Detector {

  @Override
  public MediaType detect(InputStream is, Metadata metadata) throws IOException {

    TemporaryResources tmp = new TemporaryResources();

    TikaInputStream tis = TikaInputStream.get(is, tmp);
    tis.mark(Integer.MAX_VALUE);

    try {

      MimeMessage mimeMessage = null;
      String host = "host.com";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      mimeMessage = new MimeMessage(session, tis);

      if(mimeMessage.getContentType() != null && mimeMessage.getMessageID() != null && mimeMessage.getContentType().toLowerCase().contains("multipart/signed"))
        return new MediaType("multipart", "signed");
      else
        return MediaType.OCTET_STREAM;

    } catch(Exception e) {
      return MediaType.OCTET_STREAM;
    } finally {
      try {
        tis.reset();
        tmp.dispose();
      } catch (TikaException e) {
        // ignore
    }
  }
 }
}