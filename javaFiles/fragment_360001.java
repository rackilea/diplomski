File file = new java.io.File("foo.docx");
try (FileOutputStream outputStream = new FileOutputStream(file)) {
    // if file doesn't exists, then create it
    if (!file.exists()) {
        file.createNewFile();
    }
    service.files()
        .export(fileId, "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
        .executeMediaAndDownloadTo(outputStream):
}