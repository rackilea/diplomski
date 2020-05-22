file.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return !pathname.getName().endsWith("~");
    }
})