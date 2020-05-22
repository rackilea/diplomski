Action action = new AbstractAction("shared toggle") {

    @Override
    public void actionPerformed(ActionEvent e) {
        LOG.info("pressed");
    }
};
action.putValue(Action.SELECTED_KEY, Boolean.TRUE);

JPopupMenu menu = new JPopupMenu();
menu.add(new JCheckBoxMenuItem(action));

JComponent box = new JPanel();
box.setComponentPopupMenu(menu);
box.add(new JToggleButton(action));
box.add(new JCheckBox(action));