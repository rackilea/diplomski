/**
 * The FileSystem object representing the platform's local file system.
 */
private static final FileSystem fs = DefaultFileSystem.getFileSystem();

// Snip.

public File(File parent, String child) {
    if (child == null) {
        throw new NullPointerException();
    }
    if (parent != null) {
        if (parent.path.equals("")) {
            this.path = fs.resolve(fs.getDefaultParent(),
                                   fs.normalize(child));
        } else {
            this.path = fs.resolve(parent.path,
                                   fs.normalize(child));
        }
    } else {
        this.path = fs.normalize(child);
    }
    this.prefixLength = fs.prefixLength(this.path);
}