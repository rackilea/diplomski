public void actionPerformed(ActionEvent e) {
    String command = ((JButton) e.getSource()).getActionCommand();
    JButton button = buttonCache.get(command);
    if (null != button) {
        // do something with the button
    }
}