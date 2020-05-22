File root = new File("/tmp/foobar");
File[] topDirectories = root.listFiles(new FileFilter() {
    @Override
    public boolean accept(File file) {
        return file.isDirectory();
    }
});
System.out.println("topDirectories = " + Arrays.toString(topDirectories));
for (File directory : topDirectories) {
    File recentFile = new File("");
    recentFile.setLastModified(0L);
    recentFile = getRecentFile(directory, recentFile);
    System.out.println("recentFile = " + recentFile);
}