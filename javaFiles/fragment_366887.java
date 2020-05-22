public void leaveTeam() {
    if (team != null)
    {
        team.removePlayer(this);
        team = null;
        // Do some more player stuff..
    }
}