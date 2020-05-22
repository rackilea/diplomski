final File path = new File(
            PathManager.INSTANCE.getRootPath() + "templates");
    path.mkdirs();
        final File newFile = new File(path.toString()
                + File.separator + file.getName());
    newFile.createNewFile();
    final OutputStream outStream = new FileOutputStream(newFile);
    Files.copy(file.toPath(), outStream);
    outStream.flush();
    outStream.close();