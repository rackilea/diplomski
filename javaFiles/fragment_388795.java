public File file;
public fileOpen(String fileToOpen) {
    filexists = true;
    try {
        filestream = New File(fileToOpen);
        //File exists
    } catch (IOException e) {
        filexists = false;
        // file doesn't exist
    }
}