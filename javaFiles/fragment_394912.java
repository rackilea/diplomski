Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        doSomeStuff();
        return null ;
    }
};
task.setOnSucceeded(e -> {
    Stage dialog = new Stage();
    dialog.initStyle(StageStyle.UTILITY);
    Scene scene = new Scene(new Group(new Text(25, 25, "All is done!")));
    dialog.setScene(scene);
    dialog.showAndWait();
});
new Thread(task).start();