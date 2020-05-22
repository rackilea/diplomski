primaryStage.setScene(new Scene(new VBox(), 300, 300));
primaryStage.show();

Stage secondStage = new Stage();
secondStage.setScene(new Scene(new VBox(), 50, 50));
secondStage.initOwner(primaryStage);

secondStage.show();

FileChooser fc = new FileChooser();
fc.showOpenDialog(secondStage);