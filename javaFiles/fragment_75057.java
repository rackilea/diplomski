private void leaveTrail(Pane pane, Text text){
    Text newText = new Text(text.getText());
    pane.getChildren().add(newText);
    newText.setY(text.getY());
    newText.setX(text.getX());
}