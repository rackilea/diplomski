public class SMSTrackerFX extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        /*
        TOP :: Sending SMS
        Warning: This may by subjected to costs to your mobile account
        */
        Button buttonSend = new Button("Send SMS");

        TextField number = new TextField();
        number.setPromptText("Insert number");
        HBox.setHgrow(number, Priority.ALWAYS);
        HBox hbox = new HBox(10,buttonSend, number);

        TextField message = new TextField();
        message.setPromptText("Insert text");
        HBox.setHgrow(message, Priority.ALWAYS);

        VBox vboxTop = new VBox(10,hbox,message);

        buttonSend.disableProperty().bind(Bindings.createBooleanBinding(()->{
                return number.textProperty().isEmpty()
                        .or(message.textProperty().isEmpty()).get();
            }, number.textProperty(),message.textProperty()));

        vboxTop.setPadding(new Insets(10));
        root.setTop(vboxTop);

        /*
        CENTER :: Reading SMS Inbox
        */
        Button button = new Button("Read SMS Inbox");

        ListView<SMSMessage> view = new ListView<>();
        view.setCellFactory(data -> new SMSListCell());
        VBox.setVgrow(view, Priority.ALWAYS);

        VBox vboxCenter = new VBox(10,button,view);
        vboxCenter.setPadding(new Insets(10));
        root.setCenter(vboxCenter);

        /*
        BOTTOM :: Listening to incoming SMS
        */
        Label incoming = new Label("No messages");

        VBox vboxBottom = new VBox(10,new Label("Incoming SMS"),incoming);
        vboxBottom.setPadding(new Insets(10));

        root.setBottom(vboxBottom);

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    private static class SMSListCell extends ListCell<SMSMessage> {

        @Override
        protected void updateItem(SMSMessage item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) {
                setGraphic(new Label(item.getId()+ ": " + item.getMsg()));
            } else {
                setGraphic(null);
            }
        }
    }

}