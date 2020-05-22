public class Twitter extends Application {

    @Override
    public void start(Stage primaryStage) {

        ListView<Message> listView = new ListView<>();
        listView.setCellFactory(lv -> new TwitterCell());
        listView.setItems(getMessages());

        Scene scene = new Scene(listView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Message> getMessages() {
        return FXCollections.observableArrayList(new Message("User1", "I just tweeted something sjködflk jskldjf slkd sdeklfjs kfjsl"),
                                                 new Message("User1", "I am tweeting this"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class Message {

        private String userName;
        private String content;

        public Message(String userName, String content) {
            this.userName = userName;
            this.content = content;
        }

        public String getUserName() {
            return userName;
        }

        public void setName(String name) {
            userName = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class TwitterCell extends ListCell<Message> {
        private Label lblName;
        private Label lblContent;
        private VBox  box;

        public TwitterCell() {
            setPrefWidth(100);

            lblName= new Label();
            lblContent = new Label();

            lblContent.setWrapText(true);
            box = new VBox(lblName, lblContent);
        }

        @Override
        protected void updateItem(Message message, boolean empty) {
            super.updateItem(message, empty);

            if (message == null || empty) {
                setGraphic(null);
            } else {
                lblName.setText(message.getUserName());
                lblContent.setText(message.getContent());
                setGraphic(box);
            }
        }
    }
}