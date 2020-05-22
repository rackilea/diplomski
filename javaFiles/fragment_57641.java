JBut[row][col].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        typeOfButton button = (typeOfButton) e.getSource();
        int row = button.getRow();
        int col = button.getCol();

        counter++;
        if (counter == 1) {
            JBut[row][col].setBackground(Color.RED);
        } 
        else if (counter == 2) {
            JBut[row][col].setBackground(Color.ORANGE);
        } 
        else if (counter == 3) {
            JBut[row][col].setBackground(Color.YELLOW);
        } 
        else if (counter == 4) {
            JBut[row][col].setBackground(Color.GREEN);
        } 
        else if (counter == 5){
            JBut[row][col].setBackground(Color.BLUE);
        } 
        else if (counter == 6){
            JBut[row][col].setBackground(Color.MAGENTA);
        } 
        else {
            JBut[row][col].setBackground(Color.BLACK);
            counter = 0; //makes color cycle repeat, starting with red
        } //end else
    } //end actionPerformed
}); //end ActionListener