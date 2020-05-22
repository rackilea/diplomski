public class Alpha implements Initializable {

        public static TextField tf;

        @FXML
        private TextField testTF;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tf = testTF;
        }
    }

    public class Beta {
        private void newApp() {
            if (Alpha.tf != null)
                Alpha.tf.clear();
        }
    }