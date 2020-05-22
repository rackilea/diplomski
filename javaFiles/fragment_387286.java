static void setBackground(Component c,
                          Color color) {
    if (c instanceof JTextField || c instanceof AbstractButton) {
        return;
    }

    c.setBackground(color);
    if (c instanceof Container) {
        Component[] children = ((Container) c).getComponents();
        for (Component child : children) {
            setBackground(child, color);
        }
    }
}

int show(Icon icon,
         JComponent panel) {

    String[] buttons2 = { "EXIT", "OK" };
    JOptionPane optionPane = new JOptionPane(panel,
                                             JOptionPane.PLAIN_MESSAGE, 
                                             JOptionPane.DEFAULT_OPTION,
                                             icon, 
                                             buttons2, 
                                             buttons2[1]);
    setBackground(optionPane, Color.RED);

    optionPane.createDialog(MainWindow.this, "User Input").setVisible(true);

    Object value = optionPane.getValue();
    int rc2 = JOptionPane.CLOSED_OPTION;
    if (value instanceof String) {
        rc2 = Arrays.asList(buttons2).indexOf(value);
    }

    return rc2;
}