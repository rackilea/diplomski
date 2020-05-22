public static void sortPlayers(ArrayList<BingoPlayer> players){
    BingoPlayer temp;
    int value = 0;
    for(int i = 1; i <= players.size()-1; i++)
    {

        for(int j=i;j>0;j--){
            value = compareTo(players.get(j), players.get(j - 1));

            if(value < 0){
                temp = players.get(j);
                players.set(j, players.get(j - 1));
                players.set(j - 1, temp);
            }
        }
    }

}