public Set<Thing> downloadEverything(Directory directory) {
    Set<Thing> result = new HashSet<>();
    downloadEverything(directory, result);
}

private void downloadEverything(Directory directory, Set<Thing> result) {
    for (File file : getFilesOfDirectory() {
        result.add(downloadThingFromFile(file));
    }
    for (Directory subDirectory : getSubdirectoriesOfDirectory(directory) {
        downloadEverything(subDirectory, result);
    }
}

private Thing downloadThingFromFile(File file) {
    // ...
}