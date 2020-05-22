public void writeVoid(String name, Runnable r) {
Hyperlink link = new Hyperlink(name);
link.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        r.run(); // runs the void
    }
});
t.getChildren().add(link);