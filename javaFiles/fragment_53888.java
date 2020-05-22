btn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println(mi.getText());
        System.out.println(gal.getText());
        System.out.println(gpm.getText());
    }
});
primaryStage.show();