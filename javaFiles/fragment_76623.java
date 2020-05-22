@ManyToOne(optional = false)
@JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
private Team homeTeam;

@ManyToOne(optional = false)
@JoinColumn(name = "away_team_id", referencedColumnName = "team_id")
private Team awayTeam;