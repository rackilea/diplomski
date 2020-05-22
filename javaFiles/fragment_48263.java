@Formula("(select count(*) from Player p where p.team_id = id)")
private Short amountPlayers;

@Formula("(select count(*) from Player p where p.team_id = id and p.statusPLayer=1)")
private Short amountFirstStringPlayers;

@Formula("(select count(*) from Player p where p.team_id = id and p.statusPLayer=2)")
private Short amountSecondStringPlayers;