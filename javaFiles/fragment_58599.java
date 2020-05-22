public static final Icon ok = icon("ok.png");


private static Icon icon(String path) {

    URL resource = Icons.class.getResource("/icons/" + path);
    if (resource == null) {
        // Log something...
        return null;
    }
    return new ImageIcon(resource);
}