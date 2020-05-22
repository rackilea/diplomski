private String getPaths(File[] files) {
    if (files == null || files.length == 0) {
        return "";
    }
    StringBuilder paths = new StringBuilder();
    paths.append(files[0].getAbsolutePath());
    for (int i = 1; i < files.length; i++) {
        paths.append('\n');
        paths.append(files[i].getAbsolutePath());
    }
    return paths.toString();
}