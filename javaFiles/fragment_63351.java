public static String extractFileName(String path) {

    if (path == null) {
        return null;
    }
    String newpath = path.replace('\\', '/');
    int start = newpath.lastIndexOf("/");
    if (start == -1) {
        start = 0;
    } else {
        start = start + 1;
    }
    String pageName = newpath.substring(start, newpath.length());

    return pageName;
}