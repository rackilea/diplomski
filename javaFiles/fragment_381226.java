ListSelectionModel listSelectionModel..
JList list=new JList(listSelectionModel);


list.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt) {
    if (evt.getClickCount() == 2) {
          //...Show the JDialog or JOptionPane here, not JPanel.
         String name=JOptoinPane.showInputDialog(null, "Enter your username");
    }
  }
});