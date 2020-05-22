public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);      

            Model m = new Model();
            m.listOfStringsProperty.addAll(new SimpleStringProperty("First"),
                    new SimpleStringProperty("Second"),
                    new SimpleStringProperty("Third"));

            ListView<StringProperty> lv = new ListView<StringProperty>();
            lv.setCellFactory(new Callback<ListView<StringProperty>, ListCell<StringProperty>>() {

                @Override
                public ListCell<StringProperty> call(ListView<StringProperty> param) {
                    return new ListCell<StringProperty>(){

                        @Override
                        protected void updateItem(StringProperty item, boolean empty) {

                            super.updateItem(item, empty);

                            if(item == null){
                                setText(null);
                                setGraphic(null);
                                return;
                            }

                            TextField tf = new TextField();
                            tf.textProperty().bindBidirectional(item);
                            setGraphic(tf);
                        }
                    };
                }
            });


            lv.setItems(m.listOfStringsProperty);

            root.setCenter(lv);

            // Control buttons
            HBox hbox = new HBox();
            Button buttonAdd = new Button("Add");
            buttonAdd.setOnAction(e -> m.listOfStringsProperty.add(new SimpleStringProperty("")));

            Button buttonRemove = new Button("Remove last");
            buttonRemove.setOnAction(e -> m.listOfStringsProperty.remove(m.listOfStringsProperty.size()-1));

            Button buttonPrintModel = new Button("Print model");
            buttonPrintModel.setOnAction(e -> System.out.println(m.listOfStringsProperty.toString()));

            hbox.getChildren().addAll(buttonAdd, buttonRemove, buttonPrintModel);


            root.setBottom(hbox);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}