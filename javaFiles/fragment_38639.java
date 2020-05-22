package sample;

public class ControllerMain {

    private ControllerFind children;  // controller-child

    //main-window
    @FXML
    public TextArea textAreaOne;
    @FXML
    public MenuItem findMenuItem;

    public void findAction(ActionEvent actionEvent) {
        try {
            Stage stageFind = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/find_win.fxml"));
            Parent root = loader.load();
            stageFind.setTitle("Find");
            stageFind.setMinHeight(200);
            stageFind.setMinWidth(150);
            stageFind.setResizable(false);
            stageFind.setScene(new Scene(root));
            stageFind.getIcons().add(new Image("image/search.png"));
            stageFind.initModality(Modality.NONE);
            stageFind.show();

            children = loader.getController(); //getting controller of window find_win.fxml
            children.setParent(this);   //setting parent of the controller-child - this

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}