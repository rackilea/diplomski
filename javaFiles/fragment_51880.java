boolean guess2Flag;    
 if (mouseClicked)
{

    if(!guess2Flag) 
    {
    centerClick(x1,y1);
    guess1 = board[row][column];
    board[row][column] = board[x1][y1];
    guess1 = board[x1][y1];
    JOptionPane.showInputDialog(guess1 + "this is guess1");
    guess2Flag = true;
    setColor(g);
    centerHit(xMouse, yMouse);
    g.fillOval(xMouse, yMouse, 40, 40);
    mouseClicked = false;
    }

    else if (guess2Flag)
    {
    centerClick(x1,y1);
    guess2 = board[row][column];
    board[row][column] = board[x1][y1];
    guess2 = board[x1][y1];
    JOptionPane.showInputDialog(guess2 + "this is guess2");
    guess2Flag = false;
    mouseClicked = false;
    }
}