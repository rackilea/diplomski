File testDirectory = new File("C://rootDir//");
File[] files = testDirectory.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        String name = pathname.getName().toLowerCase();
        return name.endsWith(".xml") && pathname.isFile();
    }
});