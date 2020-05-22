/**
 * Creates a directory in parentDirectory for every child of the given folder,
 * recursively.
 */
public void createDirectoriesForChildren(Folder folder, File parentDirectory) {
    for (Folder childFolder : folder.getChildren()) {
        File directory = new File(parentDirectory, childFolder.getName());
        directory.mkdirs();
        createDirectoriesForChildren(childFolder, directory);
    }
}