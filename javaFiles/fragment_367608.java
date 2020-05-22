Integer[][] boxes = new Integer[40][40];

      for (int i = 0; i < boxCount; i++) {
    for (int j = 0; j < boxCount; j++) {
        boxes[i][j] = boxPosition;
        boxPosition += 10;
    }
    boxPosition = 0; //set pixel value at the start of the row to 0 for the next column.
}