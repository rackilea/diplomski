public void decideResult() {
    if (scoreTeam1 == scoreTeam2) {
        team1.setPoints(team1.getPoints() + 1);
        team2.setPoints(team2.getPoints() + 1);
    } else if (scoreTeam1 > scoreTeam2) {
        team1.setPoints(team1.getPoints() + 2);
    } else {
        team2.setPoints(team2.getPoints() + 2);
    }
}