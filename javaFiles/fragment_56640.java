private void addRelease(Event event) throws IOException {
     Popup popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Resources/newReleasePopup.fxml"));
    Parent parent = (Parent)loader.load(); // I am not sure you need a cast here
    newReleasePopupController controller = loader.getController();
    popup.getContent().add(parent);
}