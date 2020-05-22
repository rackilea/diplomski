// Do not extend from AdjustmentBarController
public class ExaminationDisplayerController {

    ...

    public void SPECTLoad() throws SQLException, ClassNotFoundException {
        DBConnection dbConn = new DBConnection(); 
        ...
        Image image = new Image(new File("SPECT_IMAGE.jpg").toURI().toString(), 200, 200, true, true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdjustmentBar.fxml"));
        AnchorPane anchorPaneFromAdjustmentBar = loader.load();
        anchorPane.getChildren().add(anchorPaneFromAdjustmentBar);
        // Get the controller from the FXMLLoader
        AdjustmentBarController controller = (AdjustmentBarController) loader.getController();
        // Set the image
        controller.setImage(image);
        ...
    }
}