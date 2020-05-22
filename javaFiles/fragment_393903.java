import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    import java.io.IOException;

    class LoginController  {

        private Stage stage;
        private Scene scene;
        private Parent parent;
        @FXML  
        private Button gotoHomeButton;        

        public LoginController()  throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            fxmlLoader.setController(this);
            try {
                parent = (Parent) fxmlLoader.load();
                // set height and width here for this login scene
                scene = new Scene(parent, 1000, 800);
            } catch (IOException ex) {
                System.out.println("Error displaying login window");
                throw new RuntimeException(ex);
            }
        }

        // create a launcher method for this. Here I am going to take like below--
        public void launchLoginScene(Stage stage) {
           this.stage = stage;
            stage.setScene(scene);
            stage.setResizable(true);

            stage.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                    setCurrentWidthToStage(number2); 
                }
            });

            stage.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                    setCurrentHeightToStage(number2);
                }
            });

            //Don't forget to add below code in every controller
            stage.hide();
            stage.show();

        }

         @FXML
        public void authenticateUser(ActionEvent actionEvent) { 

        // write your logic to authenticate user


         // 
         new HomeController().displayHomeScreen(stage);

        } 

        private void setCurrentWidthToStage(Number number2) {
            stage.setWidth((double) number2);
        }

        private void setCurrentHeightToStage(Number number2) {
            stage.setHeight((double) number2);
        }
    }