public class Controller {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private void handleShowView1(ActionEvent e) {
        loadFXML(getClass().getResource("/sample/view_1.fxml"));
    }

    @FXML
    private void handleShowView2(ActionEvent e) {
        loadFXML(getClass().getResource("/sample/view_2.fxml"));
    }

    @FXML
    private void handleShowView3(ActionEvent e) {
        loadFXML(getClass().getResource("/sample/view_3.fxml"));
    }

    private void loadFXML(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            mainBorderPane.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}