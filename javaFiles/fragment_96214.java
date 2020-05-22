class ButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // get the button that was pressed 
        AbstractButton button = (AbstractButton) e.getSource();

        // get its background Color
        Color color = button.getBackground();

        // TODO: do what you want with the color
    }
}