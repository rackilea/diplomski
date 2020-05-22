public class ExcludeDirFileFilter implements FileFilter {
    protected final String name;

    public ExcludeDirFileFilter(String name) {
        this.name = name.toLowerCase();
    }

    public boolean accept(File file) {
        if (file.isDirectory() && file.getName().equalsIgnoreCase(name))
            return false;
        else
            return true;
    }
}