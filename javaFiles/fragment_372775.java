found = lookHorizantal(word, array, i, j);
// Maybe check between these search calls if it is found?
found = lookVertical(word, array, i, j);
// Maybe check between these search calls
found = lookDiagnal(word, array, i, j);
// Maybe check between these search calls if it is found?

public boolean lookHorizantal(char[] inWord, char[][] inArray, int row, int column)
{
    // OMITTED CODE
    if(counter == inWord.length)
    {
        return true; /*******************/
        // OMITTED CODE
    }
}