@OneToMany(mappedBy="team")
private List<Player> players; // Here your onetomany association

public short getAmountPlayers(){
return players!= null ? players.size() : 0;
}