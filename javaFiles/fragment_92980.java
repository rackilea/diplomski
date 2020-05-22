public void handle(DragEvent event) {
    //Data dropped
    //If there is an image on the dragboard, read it and use it
    Dragboard db = event.getDragboard();
    boolean success = false;
    Node node = event.getPickResult().getIntersectedNode();
    if(node != target && db.hasImage()){

        Integer cIndex = GridPane.getColumnIndex(node);
        Integer rIndex = GridPane.getRowIndex(node);
        int x = cIndex == null ? 0 : cIndex;
        int y = rIndex == null ? 0 : rIndex;
        //target.setText(db.getImage()); --- must be changed to target.add(source, col, row)
        //target.add(source, 5, 5, 1, 1);
        //Places at 0,0 - will need to take coordinates once that is implemented
        ImageView image = new ImageView(db.getImage());

        // TODO: set image size; use correct column/row span
        Board.add(image, x, y, 1, 1);
        success = true;
    }
    //let the source know whether the image was successfully transferred and used
    event.setDropCompleted(success);

    event.consume();
}