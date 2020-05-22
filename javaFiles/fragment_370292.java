String destinationFolder = "/tmp/downloadedfiles/";
List<File> files = result.getFiles();
File newFile;
if (files == null || files.isEmpty()) {
  System.out.println("No files found.");
} else {
  System.out.println("Files:");
  for (File file : files) {
    System.out.printf("%s (%s)\n", file.getName(), file.getId());
    String fileId = file.getId();
    String fileName = file.getName();
    OutputStream outputstream = new FileOutputStream(destinationFolder + fileName);
    service.files().get(fileId)
           .executeMediaAndDownloadTo(outputstream);
    outputstream.flush();
    outputstream.close();
  }
}