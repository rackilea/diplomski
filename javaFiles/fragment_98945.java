Button loginButton = new Button();
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            loginStatus.setText("Loggin in...");
            //The line below should change the color until connect does it's thing, but it doesn't
            loginStatus.setStyle("-fx-text-fill:#ffcc00"); 
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    connect(username.getText(), password.getText(), serverField.getText());
                    return null;
                }
            };
            new Thread(task).start();
        }
    });