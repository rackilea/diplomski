IntegrationMimeMessage(MimeMessage source) throws MessagingException {
        super(source);
        this.source = source;
        if (AbstractMailReceiver.this.simpleContent) {
            this.content = null;
        }
        else {
            Object complexContent;
            try {
                complexContent = source.getContent();
            }
            catch (IOException e) {
                complexContent = "Unable to extract content; see logs: " + e.getMessage();
                AbstractMailReceiver.this.logger.error("Failed to extract content from " + source, e);
            }
            this.content = complexContent;
        }
    }