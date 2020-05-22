Action action = ...;
String name = "Escape"; // I think the exact name doesn't matter
JComponent pnl = frame.getRootPane();
KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
pnl.getActionMap().put(name, action);
pnl.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, name);