public List<DownloadFiles> checkForUpdates(List<DownloadFiles> allFiles) {
    allFiles.stream()
        .filter(file -> !hasFile(file.getFilename()) || !fileUpToDate(file))
        .collect(toList())

private boolean isFileUpToDate(DownloadFiles file) {
    return DigestUtils.md5Hex(new FileInputStream(Settings.saveDir))
       .equalsIgnoreCase(DigestUtils.md5Hex(new URL(downloadUrl).openStream())));