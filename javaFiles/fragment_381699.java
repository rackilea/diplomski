File originalFile = new File("foo.bar");
    ...

    String extension = FilenameUtils.getExtension(originalFile.getName());
    String baseName = FilenameUtils.getBaseName(originalFile.getAbsolutePath());

    File renamedFile = new File(originalFile.getParent(), "newFileName." + extension);
    if (!originalFile.renameTo(renamedFile)) {
        throw new IOException("could not rename file.");
    }