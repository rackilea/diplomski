public ObservableList<User> showUserData() {
    ObservableList<User> users = FXCollections.observableArrayList();
    for (int i = 0; i <= 5; i++) {
        users.add(new User(
                new UserDetails("a name", "a username", "a position"),
                new Image("https://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-icon.png")));

    }

    return users;
}

@Override
public void start(Stage primaryStage) {
    TableView<User> table = new TableView<>(showUserData());

    TableColumn<User, Image> imageColumn = new TableColumn<>();
    TableColumn<User, UserDetails> userDetailsColumn = new TableColumn<>();
    table.getColumns().addAll(imageColumn, userDetailsColumn);

    imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
    userDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("userDetails"));

    imageColumn.setCellFactory(col -> new TableCell<User, Image>() {

        private final ImageView imageView = new ImageView();

        {
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);
            imageView.setSmooth(true);
            imageView.setPreserveRatio(true);
        }

        @Override
        protected void updateItem(Image item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                imageView.setImage(null);
                setGraphic(null);
            } else {
                imageView.setImage(item);
                setGraphic(imageView);
            }
        }

    });

    userDetailsColumn.setCellFactory(col -> new TableCell<User, UserDetails>() {

        private final Label nameLabel = new Label();
        private final Label userNameLabel = new Label();
        private final Label positionLabel = new Label();
        private final VBox vbox = new VBox(nameLabel, userNameLabel, positionLabel);

        @Override
        protected void updateItem(UserDetails item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                nameLabel.setText("Name: "+item.getName());
                userNameLabel.setText("Username: "+item.getUsername());
                positionLabel.setText("Position: "+item.getPosition());
                setGraphic(vbox);
            }
        }

    });

    Scene scene = new Scene(table);

    primaryStage.setScene(scene);
    primaryStage.show();
}