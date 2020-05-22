public String printPlayers(){        
    String result = "";
    for (Player player : this.players){
        result += " " + player.toString();
    }
    return result;
}