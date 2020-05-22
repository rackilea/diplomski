public boolean winningConditions()  {
    int noPlayersWithMoney = 0;
    for(int i = 0; i < playerCount.length; i ++)
    {
        if(playerCount[i] > 0)
        {
            noPlayersWithMoney++;
        }
    }
    if (noPlayersWithMoney == 1)
        return true;
    else 
        return false;
}