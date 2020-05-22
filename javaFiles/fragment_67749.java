btn[i] = new Button();
btn[i].setText("Safe!");

btn[i].setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});