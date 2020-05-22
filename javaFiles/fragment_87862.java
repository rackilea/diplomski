class ButtonContainer extends JPanel implements ActionListener {
    ...
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = (MainPanel)SwingUtilities.getAncestorOfClass(MainPanel.class, ButtonContainer.this);
        if (mainPanel != null) {
            // Change panel command here
        }
    }
}