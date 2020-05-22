FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("RenewCardFXML2.fxml"));
detailsPane = loader.load();
splitMenuContent.getItems().set(1, detailsPane);

RenewCardFXML2_controller controller=loader.getController();