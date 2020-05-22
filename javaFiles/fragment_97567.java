private void setSubmitValue(HttpServletRequest request) {
  String SUBMIT_PREFIX = "submit_";
  for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
    String key = (String) e.nextElement();
    if (key.startsWith(SUBMIT_PREFIX)) {
      String value = key.substring(SUBMIT_PREFIX.length());
      request.setAttribute("submit", value);
      break;
    }
  }
}