public static void renameFile(File toBeRenamed, String new_name)
    throws IOException {
    //need to be in the same path
    File fileWithNewName = new File(toBeRenamed.getParent(), new_name);
    if (fileWithNewName.exists()) {
        throw new IOException("file exists");
    }
    // Rename file (or directory)
    boolean success = toBeRenamed.renameTo(fileWithNewName);
    if (!success) {
        // File was not successfully renamed
    }
}