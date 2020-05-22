@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public void updateTeamMember(TeamMember teamMember) {
    // get all teams related to teamMember
    // for each team:
    //      if team doesn't have this team member then add
    synchronized (this){
        Iterator<Team> iteratorTeams = teamMember.getTeams().iterator();
        while(iteratorTeams.hasNext()){
            Team t = iteratorTeams.next();
            Team team = (Team) getCurrentSession().get(Team.class, t.getId());

            Set<TeamMember> teamMembers = team.getTeamMembers();
            if(!teamMembers.contains(teamMember)){
                teamMembers.add(teamMember);

                getCurrentSession().merge(teamMember); // IMPORTANT!
                getCurrentSession().merge(team); // IMPORTANT!
            }
        }

    }

    TeamMember tm = getTeamMember(teamMember.getId());
    tm.setName(teamMember.getName());
    tm.setTeams(teamMember.getTeams());
}