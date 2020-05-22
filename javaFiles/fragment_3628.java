public static void renameFile(File toBeRenamed, String new_name) {
    File fileWithNewName = new File(new_name);
    if (fileWithNewName.exists()) {
        throw new RuntimeException("file exists.");
    }
    // Rename file (or directory)
    boolean success = toBeRenamed.renameTo(fileWithNewName);
    if (!success) {
        // File was not successfully renamed
    }
}