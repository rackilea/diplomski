private void addAttachment(File file, MimeMessageHelper helper) {
  String fileName = file.getName();
  try {
    helper.addAttachment(fileName, file);
    log.debug("Added a file atachment: {}", fileName);
  } catch (MessagingException ex) {
    log.error("Failed to add a file atachment: {}", fileName, ex);
  }
}