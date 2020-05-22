// makes sure system has folder tree completely updated
private void waitFoldersComplete(Path child) throws InterruptedException {
    long folderSize;
    do {
        folderSize = FileUtils.sizeOfDirectory(child.toFile());
        System.out.println(folderSize);
        Thread.sleep(30);
    } while(folderSize < FileUtils.sizeOfDirectory(child.toFile()));
}