public HttpServletRequest getRequest() {
  RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
  if (attribs instanceof ServletRequestAttributes) {
    HttpServletRequest request = ((ServletRequestAttributes)attribs).getRequest();
    return request;
  }
  return null;
}

public String getClientIp() {
  String remoteAddr = "";
  HttpServletRequest request = getRequest();
  if (request != null) {
    remoteAddr = request.getHeader("X-FORWARDED-FOR");
    if (remoteAddr == null || remoteAddr.trim().isEmpty()) {
      remoteAddr = request.getRemoteAddr();
    }
  }
  return remoteAddr;
}