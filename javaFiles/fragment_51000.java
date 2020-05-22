/**
 * check the MessageStream
 * 
 * @param in - the inputstream to check
 * @param id - the id of a message to search for
 * @param encoding - the encoding of the stream e.g. ISO-8859
 * @return - the message with the given id of null if none is found
 * @throws IOException
 * @throws MimeException
 */
public Message checkMessageStream(InputStream in, String id, Charset encoding)
        throws IOException, MimeException {
    // https://james.apache.org/mime4j/usage.html
    String messageString = new String(StreamUtils.getBytes(in));
    messageString = fixMessageString(messageString);
    InputStream instream = new ByteArrayInputStream(
            messageString.getBytes(encoding));
    MimeTokenStream stream = new MimeTokenStream();
    stream.parse(instream);
    for (EntityState state = stream.getState(); state != EntityState.T_END_OF_STREAM; state = stream
            .next()) {
        switch (state) {
        case T_BODY:
            if (debug) {
                System.out.println("Body detected, contents = "
                        + stream.getInputStream() + ", header data = "
                        + stream.getBodyDescriptor());
            }
            break;
        case T_FIELD:
            Field field = stream.getField();
            if (debug) {
                System.out.println("Header field detected: " + stream.getField());
            }
            if (field.getName().toLowerCase().equals("message-id")) {
                // System.out.println("id: " + field.getBody() + "=" + id + "?");
                if (field.getBody().equals("<" + id + ">")) {
                    InputStream messageStream = new ByteArrayInputStream(
                            messageString.getBytes(encoding));
                    Message message = MessageServiceFactory.newInstance()
                            .newMessageBuilder().parseMessage(messageStream);
                    return message;
                } else {
                    return null;
                }
            }

            break;
        case T_START_MULTIPART:
            if (debug) {
                System.out.println("Multipart message detexted," + " header data = "
                        + stream.getBodyDescriptor());
            }
            break;
        }
    }
    return null;
}