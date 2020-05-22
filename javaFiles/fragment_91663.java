@Override
    public Object getContent() throws IOException, MessagingException {
        if (AbstractMailReceiver.this.simpleContent) {
            return super.getContent();
        }
        else {
            return this.content;
        }
    }