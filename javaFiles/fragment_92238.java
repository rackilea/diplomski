String mimeType = message.getPayload().getMimeType();
    List<MessagePart> parts = message.getPayload().getParts();
    if (mimeType.contains("alternative")) {
        log.info("entering alternative loop");
        for (MessagePart part : parts) {
            mailBody = new String(Base64.decodeBase64(part.getBody()
                    .getData().getBytes()));

        }
        log.info(mailBody);
    }