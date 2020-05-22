neighbors[x][y] = setButton(neighbors[x][y]);
private int setButton(int neighbor) {
  btn.setText((neighbor == 0 ? "" : "" + neighbor));

  if (btn.isEnabled() == true) {
        numSquaresRevealed++;
        btn.setEnabled(false);
  }

  //I want neighbor to be a reference so that I can be consistent and use it below
  return (changeNeighbors ? -1 : neighbor);
}