private static Directory getParentDirectory(String parentDirName, Directory currentDirectory, int level) {

    if (currentDirectory.getName().equals(parentDirName)) {
        return currentDirectory;

    } else {
        // Recursively search for the parent Directory
        for (Entity item : currentDirectory.contents) {
            if (item instanceof Directory) {
                Directotry result = getParentDirectory(parentDirName, (Directory) item, level + 1);
                if (result != null) {
                    return result;
                }
            }
        }
    }
    return null;
}