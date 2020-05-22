@Override
public RequestDispatcher getRequestDispatcher(final String path) {
String realPath;
 if (path.startsWith("/")) {
    realPath = path;
 } else {
    String current = exchange.getRelativePath();
    int lastSlash = current.lastIndexOf("/");
    if (lastSlash != -1) {
        current = current.substring(0, lastSlash + 1);
    }
    realPath = CanonicalPathUtils.canonicalize(current + path);
 }
 return new RequestDispatcherImpl(realPath, servletContext);
}