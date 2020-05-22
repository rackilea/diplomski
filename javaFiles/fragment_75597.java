public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

  response.setContentType("application/json");
  response.setHeader("Content-Encoding", "gzip");
  response.setContentLength(compressedJsonData .length);

  response.setStatus(Response.SC_OK);

  response.getOutputStream().write(compressedJsonData );
  response.getOutputStream().close();

  baseRequest.setHandled(true);
}