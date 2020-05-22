//----------- code snippet to track property changes in menuItem/buttonModel

    // test menu
    JMenu menu = new JMenu("Sample menu");
    menu.setMnemonic('s');
    installListeners(menu);

    // first menuitem
    JMenuItem other = menu.add("content1");
    installListeners(other);
    // second menuitem
    other = menu.add("again + ");
    installListeners(other);

    // sub
    JMenu sub = new JMenu("subMenu");
    installListeners(sub);
    menu.add(sub);

    // menus in sub
    other = sub.add("first in sub");
    installListeners(other);
    other = sub.add("second in sub");
    installListeners(other);

    getJMenuBar().add(menu);

private void installListeners(JMenuItem menu) {
    menu.getModel().addChangeListener(getChangeListener());
    menu.addChangeListener(getChangeListener());
}

private ChangeListener getChangeListener() {
    ChangeListener ch = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() instanceof ButtonModel) {
                ButtonModel model = (ButtonModel) e.getSource();
                System.out.println("from model: " + createStateText(model));
            } else if (e.getSource() instanceof JMenuItem) {
                JMenuItem item = (JMenuItem) e.getSource();
                System.out.println("  from item: " + createStateText(item));
            }
        }

        private String createStateText(ButtonModel model) {
            String text = model.getActionCommand() + " armed: " + model.isArmed();
            text += " selected: " + model.isSelected();
            text += " rollover " + model.isRollover();
            text += " pressed: " + model.isPressed();
            return text;
        }

        private String createStateText(JMenuItem model) {
            String text = model.getActionCommand() + " armed: " + model.isArmed();
            text += " selected: " + model.isSelected();
            // not supported on JMenuItem nor on AbstractButton
           // text += " rollover " + model.isRollover();
           // text += " pressed: " + model.isPressed();
            return text;
        }
    };
    return ch;
}