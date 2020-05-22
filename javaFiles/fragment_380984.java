protected String sendTemplate() {
    String template = getTemplate();
    return Optional.ofNullable(template).orElseThrow(() -> {
        return new NullPointerException("message"); // <--- RETURN here
    });
}