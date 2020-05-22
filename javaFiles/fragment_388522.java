private void setButtonDefaults(JButton but) {
    but.setBorderPainted(false);
    but.setBackground(Color.DARK_GRAY);
    but.setForeground(Color.WHITE);
    but.setName(but.getText().toLowerCase());
    but.setPreferredSize(buttonSize);
    but.addActionListener(this);
    //add focus listener
    final Color clr = ContentPane.getBackground();
    final int r = clr.getRed();
    final int g = clr.getGreen();
    final int b = clr.getBlue();
    but.addFocusListener(new FocusListener() {
        @Override
        public void focusLost(FocusEvent e) {
            log("r = " + r + ", g = " + g + ", b = " + b);
            JButton button = (JButton) e.getSource();
            button.setBackground(new Color(r, g, b));
        }

        @Override
        public void focusGained(FocusEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(new Color(r, g, b));
        }
    });
}