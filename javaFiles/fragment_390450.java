public String name()
{   
    int number = readNumber(); // read in the number
    String s = "";
    for(Player player : players){
        // check if input number match with any number of the players
        if(player.numberMatches(number))        
            s += player.getName() + " ";
    }
    return s.equals("") ? error() : s;
}