public class ComboBoxCellFactory extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            ComboBox<String> comboBox = new ComboBox<>();
            comboBox.getItems().addAll("1", "2", "3");
            //Set the cellFactory property
            comboBox.setCellFactory(listview -> new StringImageCell());
            // Set the buttonCell property
            comboBox.setButtonCell(new StringImageCell());
            BorderPane root = new BorderPane();
            root.setCenter(comboBox);
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();

        }

        //A Custom ListCell that displays an image and string
        static class StringImageCell extends ListCell<String> {

            Label label;
            static HashMap<String, Image> pictures = new HashMap<>();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setItem(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    ImageView image = getImageView(item);
                    label = new Label("",image);
                    setGraphic(label);
                }
            }

        }

        private static ImageView getImageView(String imageName) {
            ImageView imageView = null;
            switch (imageName) {
                case "1":
                case "2":
                case "3":
                    if (!pictures.containsKey(imageName)) {
                    pictures.put(imageName, new Image(imageName + ".png"));
                    }
                    imageView = new ImageView(pictures.get(new Image(imageName + ".png")));
                    break;
                default:
                    imageName = null;
            }
            return imageView;
        }

        public static void main(String[] args) {
            launch(args);
        }

    }