if (myButtons[0][6].getText().equals("O") || myButtons[0][6].getText().equals("X"))
{
    buttons[6].setEnabled(false);

    // Missing brace on previous if
    // checkXWin methods only invoked inside the above if-statement.
    if (checkHorizontalWin(letter)
        || checkVerticalWin(letter)
        || checkDiagonalToTheLeftWin(letter)
        || checkDiagonalToTheRightWin(letter)
        ) {
            win = true;

            if (win == true) {
                JOptionPane.showMessageDialog(null, letter + " has won!");
                ystem.exit(0);
            }    
        }
    }