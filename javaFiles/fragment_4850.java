ActionListener al = new ActionListener() 
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton src = (JButton) e.getSource();
        String text = button.getText();
        button.setText( text.equals("W") ? "B" : "W" );
    }
});

for (int x = 0; x < buttonPos.length; x++) {
    for (int y = 0; y < buttonPos[x].length; y++) {
        buttonPos[x][y] = new JButton();
        reversiBoard.add(buttonPos[x][y]);
        buttonPos[x][y].addActionListener( al ); // changed
    }
}