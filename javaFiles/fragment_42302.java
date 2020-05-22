JComboBox combo = getErrorLoggingOnOrOff();
JPanel panel = new JPanel(new GridLayout(0, 1));
panel.add(new JLabel("Turn Error Logging On Or Off"));
panel.add(combo);

// Here, you seem to be getting the 'selected item' before even
// showing it using a JOptionPane, which I believe will be null by default
String option = combo.getSelectedItem().toString();

try {
    int r = JOptionPane.showConfirmDialog(frame, panel, "Enable Error Logging?",
        JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (r == JOptionPane.OK_OPTION) {
            if(option.equals("On")) {
                // ...
            }
    }
}