String[] list = dir.list(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return name.matches("[0-9]+");
    }
});