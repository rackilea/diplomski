@GET
public String getAllSates(@Context HttpServletResponse response) {
    CacheControl cc = new CacheControl();
    cc.setMaxAge(86400);
    cc.setPrivate(true);
    response.addHeader("Cache-Control", cc.toString());
    [...]
}