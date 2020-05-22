// Get files from the user computer
public void getFileNames(File folder) {

    // retrieve file listing
    File[] fileList = folder.listFiles();

    if (fileList == null) {
        // throw an exception, return or do any other error handling here
        return;
    }

    // path is correct
    for (final File file : fileList ) {
        // etc etc etc
    }
}