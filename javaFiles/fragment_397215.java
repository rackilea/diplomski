public boolean findWord(String word) {
    clearButtons(); //make buttons white again
    for (int row = 0; row < length; row++) {
        for (int col = 0; col < length; col++) {
            if (findWord(word, row, col, buttons)) {
                return true;
            }
        }
    }
    return false;
}

private boolean findWord(String word, int row, int col, JButton[][] buttons) {
    if(word.equals("")) {
        return true;
    }


    if (row < 0 || row >= length || 
             col < 0 || col >= length || 
             !(this.buttons[row][col].getText().equals(word.substring(0,1))) ||
             buttons[row][col].getBackground().equals(orange)
                ) {
        return false;
    }

        String rest = word.substring(1, word.length());
        boolean letter =
               findWord(rest, row-1, col-1, buttons) ||
               findWord(rest, row-1,   col, buttons) ||
               findWord(rest, row-1, col+1, buttons) ||
               findWord(rest, row, col-1, buttons) ||
               findWord(rest, row, col+1, buttons) ||
               findWord(rest, row+1, col-1, buttons) ||
               findWord(rest, row+1,   col, buttons) ||
               findWord(rest, row+1, col+1, buttons);
        if(!letter) {
            this.buttons[row][col].setBackground(white);
        }
        return letter;
}