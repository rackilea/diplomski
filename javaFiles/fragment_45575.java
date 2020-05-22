// source is the encrypted MimeMessage 
// MimeMessageWrapper is a wrapper which can copy a messgae but keep the message ID unchanged
boolean keepMessageId = true;
MimeMessageWrapper newMime = new MimeMessageWrapper(source, keepMessageId); 

MimeMultipart mmp = new MimeMultipart("mixed");

List<MimePart> parts = MimeMultipartUtils.findPartsByMimeType(mime, "*");

for (MimePart part : parts) {

    // Do some part processing
    // Decrypt Adn verify individual parts
    // End of processing 

    ContentType type = new ContentType(part.getContentType());
    String encoding = part.getEncoding();
    String name = type.getParameter("name");

    part.setContent(new String(decPart.toByteArray()), type.toString());

    // Add the part to the brand new MimeMultipart
    mmp.addBodyPart((BodyPart) part);

}

// Set the original copy Message with the new modified content (decrypted parts)
mime.setContent(mmp);
mime.saveChanges();