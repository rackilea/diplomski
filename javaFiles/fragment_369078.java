public void createTempDirectory(){
         //Creating temporary directory for copying property files
    updateStatus("Trying to create a temp directory \n");
    File tempDir= new File(tomcat_path.getText()+filePath.path_to_temp_directory);
    if(!tempDir.exists())
        tempDir.mkdirs();

    updateStatus("Created Temp directory to copy Config Files \n");
}

// similarly for other methods

private void updateStatus(String message) {
    if (Platform.isFxApplicationThread()) {
        status_text_area.appendText(message);
    } else {
        Platform.runLater(() -> status_text_area.appendText(message));
    }
}