protected static final String EXTENSION = ".png";

protected static final String FORMAT_NAME = "png";

protected static final LayoutFileFilter SAVE_AS_IMAGE = 
        new LayoutFileFilter("PNG Image Format", EXTENSION, true);

protected int chooseSaveFile(BufferedImage image) {
    JFileChooser fileChooser = new JFileChooser();
    ExtensionFileFilter pFilter = new ExtensionFileFilter(SAVE_AS_IMAGE);
    fileChooser.setFileFilter(pFilter);
    int status = fileChooser.showSaveDialog(frame.getFrame());

    if (status == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            String fileName = selectedFile.getCanonicalPath();
            if (!fileName.endsWith(EXTENSION)) {
                selectedFile = new File(fileName + EXTENSION);
            }
            ImageIO.write(image, FORMAT_NAME, selectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return status;
}