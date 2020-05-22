public static Map<String, String> getParameterMap(ServletRequest request, String mapName) {

  Map<String, String> result = new HashMap<String, String>();     

  Enumeration<String> names = request.getParameterNames();
  while (names.hasMoreElements()) { 
    String name = names.getNextElement();
    if (name.startsWith(mapName + "[") && name.endsWith("]")) {
      result.put(name.substring(mapName.length()+1, name.length() - 2), request.getParameter(name));
    }
  }

  return result;
}