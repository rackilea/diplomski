class FilenameFilter1 implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt");
    }
}

class FilenameFilter2 extends FilenameFilter1 {
    @Override
    public boolean accept(File dir, String name) {
        return super.accept(dir, name) && new File(dir, name).isDirectory();
    }
}