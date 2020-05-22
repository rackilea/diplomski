Thread t = new Thread(() -> {
    doSomeStuff();
    Platform.runLater(() -> {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(new Group(new Text(25, 25, "All is done!")));
        dialog.setScene(scene);
        dialog.showAndWait();
    });
});
t.start();