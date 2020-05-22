//Check file type on start event:
@Override
public void uploadStarted(StartedEvent event) {
    String contentType = event.getFilename();
    if (!contentType.endsWith("txt")) {
        isValid = false;
        upload.interruptUpload();    
    }
}

//If it is txt, do some actions:
@Override
public OutputStream receiveUpload(String filename, String mimeType) {
    FileOutputStream fos = null; // Stream to write to
    if (filename != null && !filename.isEmpty() && isValid) {
        try {
            createUserDir(filename);
            fos = new FileOutputStream(file);
            return fos;
        } catch (final java.io.FileNotFoundException e) {
            log.error(e);
            return new NullOutputStream();
        }
    } else {/*Show error "Please select a file to upload."*/};

    uploadControl.interruptUpload();
    return new NullOutputStream(); 
}