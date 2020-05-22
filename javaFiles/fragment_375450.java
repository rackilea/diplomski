public static class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int numPoint = Integer.parseInt(command);
        // Perform what ever action you need
    }