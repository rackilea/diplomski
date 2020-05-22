KeyStroke releasedDown = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true);
int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
InputMap inputMap = panel.getInputMap(condition);
ActionMap actionMap = panel.getActionMap(); // there's only one ActionMap

// then use as you normally would
inputMap.put(....);
actionMap.put(...);