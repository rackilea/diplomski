File selectedFile = fchsFolderChooser.getSelectedFile();
File pngs[] = selectedFile.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".png");
    }
});