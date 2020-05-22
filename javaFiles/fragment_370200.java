TableColumn<Person, Person> multiCol = new TableColumn<>("Multiline");
    multiCol.setCellValueFactory(cellData -> 
        new ReadOnlyObjectWrapper<Person>(cellData.getValue()));
    multiCol.setCellFactory(column -> new TableCell<Person, Person>() {

        private VBox graphic ;
        private Label firstNameLabel ;
        private Label lastNameLabel ;
        private Label emailLabel ;

        // Anonymous constructor:
        {
            graphic = new VBox();
            firstNameLabel = createLabel("#66BB66");
            lastNameLabel = createLabel("#79A8D8");
            emailLabel = createLabel("#FF8888");
            graphic.getChildren().addAll(firstNameLabel, 
                    lastNameLabel, emailLabel);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }

        private final Label createLabel(String color) {
            Label label = new Label();
            VBox.setVgrow(label, Priority.ALWAYS);
            label.setMaxWidth(Double.MAX_VALUE);
            label.setStyle("-fx-background-color: "+color+" ;");
            label.setAlignment(Pos.CENTER);
            return label ;
        }

        @Override
        public void updateItem(Person person, boolean empty) {
            if (person == null) {
                setGraphic(null);
            } else {
                firstNameLabel.setText(person.getFirstName());
                lastNameLabel.setText(person.getLastName());
                emailLabel.setText(person.getEmail());
                setGraphic(graphic);
            }
        }
    });