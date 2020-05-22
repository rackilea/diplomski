public static void main(String[] args) {
  List<DownloadFiles> filesToUpdate = checkForUpdates(DownloadFiles.values());

  listFilesToUpdate(filesToUpdate);

  downloadFiles(filesToUpdate);
}

private static void downloadFiles(List<DownloadFiles> filesToUpdate) {
  filesToUpdate.stream()
      .forEach(file -> downloadFile(file));
}

private static void downloadFile(DownloadFiles file) {
  try {
    URL website = new URL(file.URL);
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    FileOutputStream fos = new FileOutputStream(file.filename);
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
  } catch (IOException e) {
    throw new RuntimeException(e);
  }
}

private static void listFilesToUpdate(List<DownloadFiles> filesToUpdate) {
  System.out.println("Following files will be updated");
  filesToUpdate.stream()
      .forEach(System.out::println);
}

public static List<DownloadFiles> checkForUpdates(DownloadFiles[] allFiles) {
  return Arrays.asList(allFiles).stream()
      .filter(file -> !hasFile(file.filename) || !isFileUpToDate(file))
      .collect(Collectors.toList());
}

private static boolean isFileUpToDate(DownloadFiles file) {
  try (InputStream is = new URL(file.URL).openStream()) {
    return DigestUtils.md5Hex(new FileInputStream(Settings.saveDir))
        .equalsIgnoreCase(DigestUtils.md5Hex(is));
  } catch (IOException e) {
    throw new RuntimeException(e);
  }
}