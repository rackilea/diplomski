private static Map<String, File> fileMap(String rootPath, File file) {
    Map<String, File> fileMap = new HashMap<>();
    fileMap.put(Paths.get(rootPath).getFileName().toString(), new File(rootPath));  // add root path
    Path path = file.toPath();

    while (!path.equals(Paths.get(rootPath))) {
        fileMap.put(path.getFileName().toString(), new File(path.toUri())); // add current dir
        path = path.getParent(); // go to parent dir
    }
    return fileMap;
}