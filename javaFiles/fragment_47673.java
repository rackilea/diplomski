package the.package;  

public class ControllerName extends StackPane{

  @FXML
  ImageView imageId;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //You can add code here. 

    //With JavaFX2
    widthProperty().addListener(new ChangeListener() { 
      @Override
      public void changed(ObservableValue ov, Object t, Object t1) {              
        myImageView.setFitWidth(stage.getWidth());
      }
    });

     //With JavaFX8 Using Lambdas
     widthProperty().addListener((ov, t, t1) ->
       myImageView.setFitWidth(getWidth()));         

  }
}