public class Main extends Application {

    private int newBookIndex = 2;        
    public final ObservableList<Book> data =  FXCollections.observableArrayList(
            new Book("123","Hugo"), new Book("456","Harry Potter"));
    private final ListView<Book> lv = new ListView<>();   

    @Override
    public void start(Stage primaryStage) {
        Button addButton = new Button("Add Book");

        lv.setCellFactory(param->new BookCell());
        lv.setItems(data);
        Scene myScene = new Scene(new VBox(10,lv,addButton), 200, 200);
        myScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(myScene);
        primaryStage.show();

        addButton.setOnAction((event)->{
            addButton.setDisable(true);
            data.add(new Book(String.valueOf(newBookIndex),"test"));

            VirtualFlow vf=(VirtualFlow)lv.lookup(".virtual-flow");
            if(!lv.lookup(".scroll-bar").isVisible()){
                FadeTransition f = new FadeTransition();
                f.setDuration(Duration.seconds(1));
                f.setFromValue(0);
                f.setToValue(1);
                f.setNode(vf.getCell(lv.getItems().size()-1));
                f.setOnFinished(t->{
                    newBookIndex++;
                    addButton.setDisable(false);                        
                });
                f.play();
            } else {
                PauseTransition p = new PauseTransition(Duration.millis(20));
                p.setOnFinished(e->{
                    vf.getCell(lv.getItems().size()-1).setOpacity(0);
                    vf.show(lv.getItems().size()-1);
                    FadeTransition f = new FadeTransition();
                    f.setDuration(Duration.seconds(1));
                    f.setFromValue(0);
                    f.setToValue(1);
                    f.setNode(vf.getCell(lv.getItems().size()-1));
                    f.setOnFinished(t->{
                        newBookIndex++;
                        addButton.setDisable(false);                        
                    });
                    f.play();
                });
                p.play();
            }
        });
    }

    class BookCell extends ListCell<Book>{
        private final Text text = new Text();
        private final HBox h = new HBox(text);

        {
            getStyleClass().add("book-list-cell");
        }

        @Override
        protected void updateItem(Book item, boolean empty){
            super.updateItem(item, empty);
            if(item!=null && !empty){
                text.setText(item.getIsbn());
                setGraphic(h);
            } else {
                setGraphic(null);
                setText(null);
            }
        }
    }

    class Book {
        private Book(String isbn, String name) {
            this.isbn.set(isbn);
            this.name.set(name);
        }

        private final StringProperty name = new SimpleStringProperty();

        public String getName() {
            return name.get();
        }

        public void setName(String value) {
            name.set(value);
        }

        public StringProperty nameProperty() {
            return name;
        }

        private final StringProperty isbn = new SimpleStringProperty();

        public String getIsbn() {
            return isbn.get();
        }

        public void setIsbn(String value) {
            isbn.set(value);
        }

        public StringProperty isbnProperty() {
            return isbn;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}