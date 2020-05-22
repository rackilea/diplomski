final JMenu menu = new JMenu("Test JMenu");
final JMenuItem menuItem = new JMenuItem("Initial Text");
menuItem.setAction(new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.setText("Different Text");
    }

});
menu.add(menuItem);