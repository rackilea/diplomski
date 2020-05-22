/**
 * Will move the source File to the destination File.
 * The Method will backup the dest File, copy source to
 * dest, and then will delete the source and the backup.
 * 
 * @param source
 *            File to be moved
 * @param dest
 *            File to be overwritten (does not matter if
 *            non existent)
 * @throws IOException
 */
public static void moveAndOverwrite(File source, File dest) throws IOException {
    // Backup the src
    File backup = CSVUtils.getNonExistingTempFile(dest);
    FileUtils.copyFile(dest, backup);
    FileUtils.copyFile(source, dest);
    if (!source.delete()) {
        throw new IOException("Failed to delete " + source.getName());
    }
    if (!backup.delete()) {
        throw new IOException("Failed to delete " + backup.getName());
    }
}

/**
 * Recursive Method to generate a FileName in the same
 * Folder as the {@code inputFile}, that is not existing
 * and ends with {@code _temp}.
 * 
 * @param inputFile
 *            The FileBase to generate a Tempfile
 * @return A non existing File
 */
public static File getNonExistingTempFile(File inputFile) {
    File tempFile = new File(inputFile.getParentFile(), inputFile.getName() + "_temp");
    if (tempFile.exists()) {
        return CSVUtils.getNonExistingTempFile(tempFile);
    } else {
        return tempFile;
    }
}