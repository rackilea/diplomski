void mousePressed() {
    boolean hit = false;
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {

        if (boxes[i][j].light == true && boxes[i][j].onPress(mouseX, mouseY)) {
            boxes[i][j].light = false;
            hit = true;
        }
      }
    }
    println(hit ? "yes" : "no");
}