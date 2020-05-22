@Override
public void actionPerformed(ActionEvent e) {
    Object eventSource = e.getSource();
    if (eventSource instanceof JButton) {
        JButton buttonClicked = (JButton) eventSource;
        Color bg = buttonClicked.getBackground();
        if (bg.equals(Color.white)) {
            buttonClicked.setBackground(Color.yellow);
        } else if (bg.equals(Color.yellow)) {
            buttonClicked.setBackground(Color.white);
        }
    }
}