Button btn = new Button();
btn.setText("Close");
btn.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
       System.exit(0);
    }
});