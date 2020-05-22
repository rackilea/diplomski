private List<Path> scanForJsons(Path pathScanned){
    List<Path> pathList = new ArrayList<>();
    try {
            Files.walk(pathScanned).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                pathList.add(filePath);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
    }
    return pathList;
}