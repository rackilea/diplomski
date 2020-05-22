@FXML
public void handleOpenFileAction(ActionEvent event) {       
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open a File");
    this.file = Paths.get(fileChooser.showOpenDialog(new Stage()).toURI());
    // note the slightly cleaner version:
    // this.file = fileChooser.showOpenDialog(new Stage()).toPath();


    try {
        List<String> lines = Files.readAllLines(this.file, Charset.defaultCharset());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/HassanAlthaf/Editor.fxml"));
        Parent root = loader.load();
        EditorController editorController = loader.getController();
        editorController.openEditor(lines);

    } catch(IOException ex) {
        System.out.println(ex);
    }
}