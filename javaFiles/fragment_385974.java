// Component that you want listening to your key
JComponent component = ...;
component.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0),
                        "actionMapKey");
component.getActionMap().put("actionMapKey",
                         someAction);