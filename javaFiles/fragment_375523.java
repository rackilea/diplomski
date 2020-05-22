JButton[][] buttons = new JButton[row][col];
for(int i = 1; i<= row; i++){
    for( int p=1; p<= col; p++){
       buttons[i][p] = new JButton();
       boardPanel.add(buttons[i][p]);   
    }
}