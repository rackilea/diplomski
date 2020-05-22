// Component that you want listening to your key
JComponent component = ...;
component.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,
                            java.awt.event.InputEvent.CTRL_DOWN_MASK),
                    "actionMapKey");
component.getActionMap().put("actionMapKey",
                     someAction);