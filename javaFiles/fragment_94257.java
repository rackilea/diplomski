@ManyToMany( targetEntity = PlayerEntity.class )   
@JoinTable(name = "Game_HomeTeamPlayers")
private Collection<Player> homeTeamPlayers; 

@ManyToMany( targetEntity = PlayerEntity.class ) 
@JoinTable(name = "Game_AwayTeamPlayers")
private Collection<Player> awayTeamPlayers;