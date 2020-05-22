private JTextField[] fields = new JTextField[TEXT_FIELD_COUNT]; // const = 52
private Box[] boxes = new Box[SUIT_COUNT];  // suit count = 4

for (int i = 0; i < boxes.length; i++) {
  boxes[i] = Box.createHorizontalBox();
  for (int j = 0; j < TEXT_FIELD_COUNT/SUIT_COUNT; j++) {
    int index = i * (TEXT_FIELD_COUNT / SUIT_COUNT) + j;
    fields[index] = new JTextField(COLS); // COLS = some const, possibly 10
    boxes[i].add(fields[index]); 
    // add your strut if desired
  }
}