protected String sendTemplate() {
    String template = getTemplate();
    return Optional.ofNullable(template).orElseThrow(() -> {
        throw new NullPointerException("message");
    });
}