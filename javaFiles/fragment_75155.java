public class ExcludeExtensionInDirFileFilter implements FileFilter {
    protected final String parentFolder;
    protected final String extension;

    public ExtensionFileFilter(String parentFolder, String extension) {
        this.parentFolder = parentFolder;
        this.extension = extension.toLowerCase();
    }

    public boolean accept(File file) {
        if (!file.isDirectory() && file.getParentFile().getName().equalsIgnoreCase(parentFolder))
            return !file.getAbsolutePath().toLowerCase().endsWith(extension);
        else
            return true;
    }
}