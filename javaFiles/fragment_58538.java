class FileContainer {
    private final File dir;
    public FileContainer(File aDir) { dir = aDir; }
    public boolean contains(String aFile) {
        return new File(dir, aFile).isFile();
    }
}