File[] files = new File(".").listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().startsWith("janurary");
    }
});