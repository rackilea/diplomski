@FXML
protected void handleBrowseWindowsExplorer(ActionEvent event) {
    DirectoryChooser TestDataDir = new DirectoryChooser();
    TestDataDir.setTitle("Select path");
    File selectedDir = TestDataDir.showDialog(null);

    if (selectedDir == null) {
        BrowseStatus.setText("Nothing choosen");
        FileListTable.getItems().clear();
        TDpath.setText("");
    } else {
        TDpath.setText(selectedDir.getAbsolutePath());
        BrowseStatus.setText("Folder has been selected");
        File[] listOfFiles = selectedDir.listFiles();

        ArrayList<FilesInDir> fidlist = new ArrayList<>(listOfFiles.length);

        for (File listOfFile : listOfFiles) {
            fidlist.add(new FilesInDir(listOfFile.getName()));
        }

        FileListTable.getItems().setAll(fidlist);
    }
}