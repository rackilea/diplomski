class ButtonActionListener extends ActionListener {
    private JButton previousButton = null;

    @Override
    public void actionPerformed(ActionEvent e){
        JButton currentButton = (JButton)e.getSource();
        if (previousButton == null) {
            previousButton = currentButton;
            return;
        }

        Icon previousIcon = previousButton.getIcon();
        Icon currentIcon = currentButton.getIcon();
        currentButton.setIcon(previousIcon);
        previousButton.setIcon(currentIcon);
        previousButton = null;
    }
}