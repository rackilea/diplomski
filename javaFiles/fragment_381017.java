// assuming displayed a main JPanel called mainJPanel
ActionMap actionMap = mainJPanel.getActionMap();
int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
InputMap inputMap = mainJPanel.getInputMap(condition);

// assuming a class, CreateBulletAction, that extends AbstractAction
// and that creates your bullets
inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
actionMap.put("space", new CreateBulletAction());