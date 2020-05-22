private <T extends Token> T[] execPost(WebTarget target, String content, Class<T[]> tokenClass) {
    T[] arr = null;
    try {
        arr = target.request().post(Entity.json(new Text(content)), tokenClass);
    } catch (javax.ws.rs.BadRequestException bre) {
        LOG.error(bre.getMessage());
    }
    return arr;
}