JFileChooser fc = new JFileChooser();
fc.addChoosableFileFilter(new FileFilter() {

    @Override
    public boolean accept(File f) {
        String name = f.getName().toLowerCase();
        return (name.endsWith(".png") &&
                        name.endsWith(".jpg") &&
                        name.endsWith(".gif") &&
                        name.endsWith(".bmp") &&
                        f.length() < 3 * (1024 * 1024));
    }

    @Override
    public String getDescription() {
        return "Images < 3mb";
    }
});