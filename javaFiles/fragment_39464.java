JFrame f = ...
WindowUtils.setWindowTransparent(f, true);
// ensure JPanel content pane doesn't paint its (solid) background
f.getContentPane().setOpaque(false);
// Any other added components will be painted normally
f.getContentPane().add(new JButton("I'm opaque"));