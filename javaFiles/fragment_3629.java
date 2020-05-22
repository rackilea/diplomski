public static boolean renameFile(File toBeRenamed, String new_name) {
    //need to be in the same path
    File fileWithNewName = new File(toBeRenamed.getParent(), new_name);
    if (fileWithNewName.exists()) {
        return false;
    }
    // Rename file (or directory)
    return toBeRenamed.renameTo(fileWithNewName);
}