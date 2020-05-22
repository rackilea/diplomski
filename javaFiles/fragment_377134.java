/**
     * This is a recursive method that calculates and displays the combinations of the coins included in
     * coinAmounts that sum to amountToBeChanged.
     * 
     * @param coinsUsed is a list of each coin used so far in the total.  If this branch is successful, we will add another coin on it.
     * @param largestCoinUsed is used in the recursion to indicate at which coin we should start trying to add additional ones.
     * @param amountSoFar is used in the recursion to indicate what sum we are currently at.
     * @param amountToChange is the original amount that we are making change for.
     * @return the number of successful attempts that this branch has calculated.
     */private static int change(List<Integer> coinsUsed, Integer currentCoin, Integer amountSoFar, Integer amountToChange)
    {
        //if last added coin took us to the correct sum, we have a winner!
        if (amountSoFar == amountToChange)
        {
            //output 
            System.out.print("Change for "+amountToChange+" = ");

            //run through the list of coins that we have and display each.
            for(Integer count: coinsUsed){

                System.out.print(count + " ");
            }
            System.out.println();       

            //pass this back to be tallied
            return 1;
        }

        /*
         * Check to see if we overshot the amountToBeChanged
         */
        if (amountSoFar > amountToChange)
        {
            //this branch was unsuccessful
            return  0;
        }

        //this holds the sum of the branches that we send below it
        int successes=0;

        // Pass through each coin to be used
        for (Integer coin:coinAmounts)
        {
            //we only want to work on currentCoin and the coins after it
            if (coin >= currentCoin)
            {
                //copy the list so we can branch from it
                List<Integer> copyOfCoinsUsed = new ArrayList<Integer>(coinsUsed);

                //add on one of our current coins
                copyOfCoinsUsed.add(coin);

                //branch and then collect successful attempts
                successes += change(copyOfCoinsUsed, coin, amountSoFar + coin, amountToChange);
            }
        }

        //pass back the current
        return successes;

    }