for (int i = 0; i < lotto.length; i++) {
    int number;
    Boolean wasFound = isFound(lotto, number = (int) (Math.random() * 50));

    if (!wasFound)
    {
        lotto[i] = number;
    }
    else
    {
        // perform the previous iteration again
        i--;
    }
}