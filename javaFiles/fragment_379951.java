URL imageResource = getClass().getResource("image.gif");
    File imageFile = File.createTempFile(
            FilenameUtils.getBaseName(imageResource.getFile()),
            FilenameUtils.getExtension(imageResource.getFile()));
    IOUtils.copy(imageResource.openStream(),
            FileUtils.openOutputStream(imageFile));