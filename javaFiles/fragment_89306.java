class TeamPlay {
    @ManyToOne
    Team homeTeam;

    @ManyToOne
    Team awayTeam;
}

class Team {
    @OneToMany(mappedBy="homeTeam")
    Set<TeamPlay> homeTeamPlays;

    @OneToMany(mappedBy="awayTeam")
    Set<TeamPlay> awayTeamPlays;
}