/****** Check to see if the game is complete **/
public boolean isSolved() {
    for (int element : puzzle) {
        if (element == 0)
            return false;
    }
    return true;
}