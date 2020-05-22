public static int compareTo(BingoPlayer player1, BingoPlayer player2){
    if(player1.firstName.compareTo(player2.firstName) != 0)
        return player1.firstName.compareTo((player2.firstName));
    else 
        return player1.lastName.compareTo((player2.lastName));
}