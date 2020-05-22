handler.setFileNameGenerator(message -> {
    if (message.getPayload() instanceof File) {
        return ((File) message.getPayload()).getName();
    } else {
        throw new IllegalArgumentException("File expected as payload.");
    }
});