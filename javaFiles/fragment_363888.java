CardLayout layout = new CardLayout();
panelCombination.setLayout(layout);
// add all panels.
....
private void PreviousMouseClicked(java.awt.event.MouseEvent evt) { 
    layout.previous(panelCombination);