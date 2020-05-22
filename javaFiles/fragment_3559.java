FileMetaData fileMeta = new FileMetaDataBuilder(fileContainer.getMetaData())
    .setFileName("file name")
    .setServer("my box")
    .setDirectory("/path/to/dir")
    .setFileType(FileType.PROPERTIES)
    .build();