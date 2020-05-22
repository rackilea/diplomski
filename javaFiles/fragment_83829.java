public boolean isInQuery(HttpServletRequest request, String key) {
  String query = request.getQueryString();
  String[] nameValuePairs = query.split("&");
  for(String nameValuePair: nameValuePairs) {
    if(nameValuePair.startsWith(key + "=")) {
      return true;
    }
  }
  return false;
}