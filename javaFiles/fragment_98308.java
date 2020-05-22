public class MultipartWrapper extends HttpServletRequestWrapper {
  MultipartRequest mreq = null;
  public MultipartWrapper(HttpServletRequest req, String dir)
                                 throws IOException {
super(req);
mreq = new MultipartRequest(req, dir);
  }
  // Methods to replace HSR methods
  public Enumeration getParameterNames() {
return mreq.getParameterNames();
  }
  public String getParameter(String name) {
return mreq.getParameter(name);
  }
  public String[] getParameterValues(String name) {
return mreq.getParameterValues(name);
  }
  public Map getParameterMap() {
Map map = new HashMap();
Enumeration enum = getParameterNames();
while (enum.hasMoreElements()) {
  String name = (String) enum.nextElement();
  map.put(name, mreq.getParameterValues(name));
}
return map;
  }
  // Methods only in MultipartRequest
  public Enumeration getFileNames() {
return mreq.getFileNames();
  }
  public String getFilesystemName(String name) {
return mreq.getFilesystemName(name);
  }
  public String getContentType(String name) {
return mreq.getContentType(name);
  }
  public File getFile(String name) {
return mreq.getFile(name);
  }
}