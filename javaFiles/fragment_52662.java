public byte[] getImage(HttpServletResponse resp) {
    try {
        // return your image
    } catch (Exception e) {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}