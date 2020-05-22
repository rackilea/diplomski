public final void InitialUI() { // this should be named initialUi()

  // ..... code deleted for brevity

  panel.add(baTan);
  add(panel);
  // !!  setVisible(true); // *** don't call this here ***
  ActionListener operandListener = new OperandListener();

  // ..... code deleted for brevity

}