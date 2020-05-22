@Override
protected JButton createArrowButton()
{
    final JButton button = new BasicArrowButton(BasicArrowButton.SOUTH, buttonBackground, borderBox, arrowColor, buttonBorder);
    LineBorder border = new LineBorder(buttonBorder, 1);
    button.setEnabled(false);
    button.setBorder(border);
    button.addChangeListener(new ChangeListener(){

        @Override
        public void stateChanged(ChangeEvent arg0) {
            if(button.isEnabled())
                button.setBackground(Color.WHITE);
            else
            {
                button.setBackground(ColorPalette.LIGHT_GREY);
                button.setBorder(new LineBorder(ColorPalette.LIGHT_GREY, 1));
            }
        }
    });
    return button;  
}