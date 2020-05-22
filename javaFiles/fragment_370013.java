// assume JTable is named "table"
  int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
  InputMap inputMap = table.getInputMap(condition);
  ActionMap actionMap = table.getActionMap();

  // DELETE is a String constant that for me was defined as "Delete"
  inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE);
  actionMap.put(DELETE, new AbstractAction() {
     public void actionPerformed(ActionEvent e) {
        // TODO: do deletion action here
     }
  });