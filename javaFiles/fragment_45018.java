public int numPossibilities(int numDice, int sum) {
    if (numDice == sum)
        return 1;
    else if (numDice == 0 || sum < numDice)
        return 0;
    else
        return numPossibilities(numDice, sum - 1) +
               numPossibilities(numDice - 1, sum - 1) -
               numPossibilities(numDice - 1, sum - 7);
}