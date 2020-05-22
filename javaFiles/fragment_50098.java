InputMap inMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
  ActionMap actMap = panel.getActionMap();

  for (final Key key : Key.values()) {
     KeyStroke altPressed = KeyStroke.getKeyStroke(key.getKeyCode(),
           InputEvent.ALT_DOWN_MASK, false);
     KeyStroke altReleased = KeyStroke.getKeyStroke(key.getKeyCode(),
           InputEvent.ALT_DOWN_MASK, true);
     KeyStroke released  = KeyStroke.getKeyStroke(key.getKeyCode(),
           0, true);

     inMap.put(altPressed, altPressed.toString());
     inMap.put(altReleased, altReleased.toString());
     inMap.put(released, released.toString());

     actMap.put(altPressed.toString(), new AbstractAction() {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
           keyMap.put(key, true);
        }
     });

     Action releaseAction = new AbstractAction() {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
           keyMap.put(key, false);
        }
     };

     actMap.put(altReleased.toString(), releaseAction);
     actMap.put(released.toString(), releaseAction);