CardLayout myCardLayout = new CardLayout();
JPanel cardHolderPanel = new JPanel(myCardLayout);

// here add items to the JList and the cardHolderPanel, using the same String
// added to the JLabel as the key 2nd parameter to the add(...) method


// elsewhere...
public void valueChanged(ListSelectionEvent e) {
  String selection = stepList.getSelectedValue().toString();
  myCardLayout.show(cardHolderPanel, selection);
}