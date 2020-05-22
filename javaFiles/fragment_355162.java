public void play(int ypos, int xpos) {
        if (model.isEmpty(xpos,ypos)) {// changed x and y because it lands   in    the wrong position.
        // TO DO: Put the O in xpos ypos using the model.
     model.placeO(xpos,ypos);
     // TO DO: Put the X using the model.
     drawBoard();
     view.repaint();
     model.putX();
     drawBoard();
     view.repaint();



    }
    // TO DO: add the conditions inside the () of the if's that determine  the   winner.
        if( didWin('X') ) 
        JOptionPane.showMessageDialog(null,"X Wins","Winner",    JOptionPane.INFORMATION_MESSAGE);
    else if ( didWin('O')  )
        JOptionPane.showMessageDialog(null,"O    Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
}