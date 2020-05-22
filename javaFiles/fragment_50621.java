public void login(ActionEvent event) {   

    Task<Boolean> loginTask = new Task<Boolean>() {
        @Override
        protected Boolean call() throws Exception {
            return Compte.login(username.getText(), password.getText());
        }
    };

    loginTask.setOnSucceeded(e -> {

        if (loginTask.getValue()) {
            Parent root = FXMLLoader.load(getClass().getResource("/views/PrincipalFram.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("My Title");
            stage.show();
        } else {
            //TODO 
        }
        loader.setVisible(false);
    });

    loginTask.setOnFailed(e -> {
        loader.setVisible(false);
    });

    Thread thread = new Thread(task);
    thread.setDaemon(true);
    loader.setVisible(true);
    thread.start();
}