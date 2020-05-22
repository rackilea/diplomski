public void Autentificare(ActionEvent event) {
    try {
        Optional<User> optional = loginVerifier.login(Numeutilzator.getText(), Parola.getText());

        if(optional.isPresent()) {
            String fxmlFile = optional.get().isAdmin() ? "/LicentaApp/Meniu_Admin.fxml" : "/LicentaApp/Meniu.fxml";

            Stare.setText("Autentificare reusita !");
            ((Node)event.getSource()).getScene().getWindow().hide();

            Stage st = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane Pane = loader.load(getClass().getResource(fxmlFile).openStream());

            Scene scene = new Scene(Pane);
            scene.getStylesheets().add(getClass().getResource("Style1212.css").toExternalForm());
            st.setScene(scene);
            st.show();
        }
        else {
            Stare.setText("Nume de utilizator sau parola incorect");
        }
    }
    catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}