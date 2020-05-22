public Gui(int[] states) {
  this.states = states;
  frame = new JFrame("Game of Life by Boris Verwoerd");

  baseFrame = new JPanel();
  baseFrame.setSize(500, 500);

  frame.add(baseFrame);

  base = new GridLayout(DIMENSION, DIMENSION);
  base.setHgap(-1);
  base.setVgap(-1);

  baseFrame.setLayout(base);

  box = new JPanel[DIMENSION * DIMENSION];

  for (int i = 0; i < (DIMENSION * DIMENSION); i++) {
     baseFrame.add(box[i] = new JPanel());
     box[i].setBorder(BorderFactory.createLineBorder(Color.black));
  }

  frame.setSize(500, 500);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);
  frame.validate();
  frame.repaint();

  gameLoop();
}