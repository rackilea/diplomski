// Create the custom dialog.
    Dialog<Pair<String, String>> dialog = new Dialog<>();
    dialog.setTitle("TestName");

    // Set the button types.
    ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(20, 150, 10, 10));

    TextField from = new TextField();
    from.setPromptText("From");
    TextField to = new TextField();
    to.setPromptText("To");

    gridPane.add(from, 0, 0);
    gridPane.add(new Label("To:"), 1, 0);
    gridPane.add(to, 2, 0);

    dialog.getDialogPane().setContent(gridPane);

    // Request focus on the username field by default.
    Platform.runLater(() -> from.requestFocus());

    // Convert the result to a username-password-pair when the login button is clicked.
    dialog.setResultConverter(dialogButton -> {
        if (dialogButton == loginButtonType) {
            return new Pair<>(from.getText(), to.getText());
        }
        return null;
    });

    Optional<Pair<String, String>> result = dialog.showAndWait();

    result.ifPresent(pair -> {
        System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
    });