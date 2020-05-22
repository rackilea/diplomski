@FXML
public TextArea textareaContent;

@FXML
private Parent root;

public void openEditor(List<String> lines) throws IOException {
    Scene scene = new Scene(this.root);

    Stage stage = new Stage();

    stage.setScene(scene);
    stage.setTitle("Editting File");
    for(String line : lines) {
        this.textareaContent.appendText(line + "\n");
    }
    stage.show();
}