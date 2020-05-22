JCheckBox[][] seats = new JCheckBox[4][10];
for (int row = 0; row < seats.length; row++) {
  for (int col = 0; col < seats[row].length; col++) {
    seats[row][col] = new Seat();
    seatPanel.add(seats[row][col]);
  } 
}