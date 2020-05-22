if (decodeFileName && filename != null) {
    try {
    filename = MimeUtility.decodeText(filename);
    } catch (UnsupportedEncodingException ex) {
    throw new MessagingException("Can't decode filename", ex);
    }
}