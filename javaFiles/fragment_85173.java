Action oldAction = preisFieldEUR.getActionMap().get("caret-forward"); // probably another parameter?
AbstractAction right = new AbstractAction() {
  @Override
  public void actionPerformed(ActionEvent e) {
    if (preisFieldEUR.getSelectionEnd() - preisFieldEUR.getSelectionStart() == preisFieldEUR.getText().length()) {
      preisFieldEUR.setSelectionStart(0);
      preisFieldEUR.setSelectionEnd(0);
    } else {
        oldAction.actionPeformed(e)
    }
  }
};