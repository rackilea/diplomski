refresh.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        imgView.setImage(new Image("card/" + cardNum() + ".png"));
        imgView2.setImage(new Image("card/" + cardNum() + ".png"));
        imgView3.setImage(new Image("card/" + cardNum() + ".png"));
        imgView4.setImage(new Image("card/" + cardNum() + ".png"));
    }
});