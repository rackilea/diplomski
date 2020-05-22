try {
    String xml = "<person>damian</person>";
    FacesContext ctx = FacesContext.getCurrentInstance();
    final HttpServletResponse resp = (HttpServletResponse)ctx.getExternalContext().getResponse();

    resp.setContentType("text/xml");
    resp.setContentLength(xml.length());
    resp.getOutputStream().write(xml.getBytes());
    resp.getOutputStream().flush();
    resp.getOutputStream().close();

    ctx.responseComplete();

} catch (IOException e) {
    e.printStackTrace();
}