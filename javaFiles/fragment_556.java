this.pauseTask = new Button("", new ImageView(pauseImage));
this.pauseTask.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent event) {
        pause();
    }
});