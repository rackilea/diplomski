@Column(name="first_team_id")
 private Long firstTeamId;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "team_id", referencedColumnName = "id")
private Team firstTeam;