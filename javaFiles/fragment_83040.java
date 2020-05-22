@FXML
TextField tf1;
@FXML
TextField tf2;
@FXML
TextField tf3;

TextField txt;

@FXML
public void btnDelete(ActionEvent actionEvent) {
    txt.setText( txt.getText().substring(0, txt.getText().length()-1));
}

@Override
public void initialize(URL url, ResourceBundle rb) {   

    tf1.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue){
                txt=tf1;
            }
        }
    });

    tf2.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue){
                txt=tf2;
            }
        }
    });

    tf3.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue){
                txt=tf3;
            }
        }
    });
}