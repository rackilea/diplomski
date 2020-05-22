// This code should go within the same class that you declare your ArrayList
private class ButtonClickListener implements ActionListener {

    // This is the method that will be called when a button is clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            lotteryNumbers.add(Integer.parseInt(((JButton)e.getSource()).getText()));
        }
    }
}