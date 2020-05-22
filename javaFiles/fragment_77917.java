private int calcSlot(Point2D mouse){
    int colPos = (int) (COLUMNS - (Camera.width - mouse.getX()) / slot.getWidth());
    int rowPos = (int) (ROWS - ((mouse.getY())- slot.getHeight()) / slot.getHeight());


    if (colPos > COLUMNS || colPos < 0 || rowPos < 0 || rowPos > ROWS + 1) {
        dropItem();
        return -1;
    } else {
        return COLUMNS*rowPos + colPos;
    }

}