public static boolean canWrite(File installDir) {
    if (installDir.canWrite() == false)
        return false;

    if (!installDir.isDirectory())
        return false;

    File fileTest = null;
    try {
        // we use the .dll suffix to properly test on Vista virtual directories
        // on Vista you are not allowed to write executable files on virtual directories like "Program Files"
        fileTest = File.createTempFile("writtableArea", ".dll", installDir);
    } catch (IOException e) {
        //If an exception occured while trying to create the file, it means that it is not writable
        return false;
    } finally {
        if (fileTest != null)
            fileTest.delete();
    }
    return true;
}