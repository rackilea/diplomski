protected File asAbsoluteFile(File f) {
    String path = f.getPath();

    // ensure we're getting a path in the form that URL can handle
    if (path != null) {
        path = path.replaceAll("\\\\", "/");
    }
    Location location = getLocation(path);

    if (location == null) {
        //can't find the file, let the parent implementation have a try
        return super.asAbsoluteFile(f);
    }
    try {
        return location.getFile();
    } catch (IOException e) {
        throw new RuntimeException("unable to read file " + f.getPath(), e);
    }
}