public Player highestBidder()
{
    Player currentHighestBidder;

    //I am assuming you would logically keep track of the number of players, in an ArrayList in this case.
    for(int p = 0; p < players.size(); p++)
    {
        //Could easily combine this 'if' and the next one, but I prefer to keep my conditionals separated. It is probably a better practice to combine them using '||'
        if(currentHighestBidder == null)
        {
            currentHighestBidder = players.get(p);
        }

        if(players.get(p).currentBid > currentHighestBidder.currentBid)
        {
            currentHighestBidder = players.get(p);
        }
    }
    return currentHighestBidder;
}