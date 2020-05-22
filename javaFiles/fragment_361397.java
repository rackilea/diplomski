public class financeFormula extends JFrame {
    public static final String LARGE_FONT = "Large Font"; // !!  constant

    //  ....

    public void buildTextMenu() {
        fontSize = new JMenuItem(LARGE_FONT); // !!  Use constant
        fontSize.setMnemonic(KeyEvent.VK_2);
        fontSize.addActionListener(new FontListener());
        textMenu = new JMenu("Text");
        textMenu.add(fontSize);
    }

    // ....

    private class FontListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // !! block change
            String actionCommand = e.getActionCommand();
            if (actionCommand.equals(LARGE_FONT)) { // !!  check for Large Font, and if pressed set the Fonts
                if (presentValuePanel != null && presentValuePanel.isEnabled()) {  // Check for null!
                    principalMessage.setFont(new Font("sans-serif", Font.PLAIN, 22));
                } else if (simpleInterestPanel != null && simpleInterestPanel.isEnabled()) {  // Check for null!
                    principalMessage.setFont(new Font("sans-serif", Font.PLAIN, 22));
                }
            }
            // !! block change
        }
    }