private void generateWinsLossesFromInput(String filePath)
{
    Scanner input = new Scanner(filePath);
    List<Team> teams = new ArrayList<Team>();
    while(input.hasNext())
    {
        String match = input.next();
        // Split the line and get teams and their scores.
        String[] splittedMatch = match.split("\\s+");
        String firstTeam = splittedMatch[0];
        int firstTeamScore = Integer.parseInt(splittedMatch[1]);
        String secondTeam = splittedMatch[2];
        int secondTeamScore = Integer.parseInt(splittedMatch[3]);

        if(firstTeamScore > secondTeamScore)
        {
            addWinner(firstTeam, teams);
            addLoser(secondTeam, teams);
        }
        else
        {
            if(secondTeamScore > firstTeamScore)
            {
                addWinner(secondTeam,teams);
                addLoser(firstTeam, teams);
            }
        }
    }
}

private void addWinner(String team, List<Team> teams)
{
    int index = 0;
    for(index = 0; index<teams.size(); index++)
    {
        Team t = teams.get(index);
        if(t.getName().equalsIgnoreCase(team))
        {
            // Team already exists, so just increment its winsCount
            t.setWinsCount(t.getWinsCount() + 1);
            break;
        }
    }

    if(index == teams.size())
    {
        // team not found, So add it as new team to the list.
        Team t = new Team();
        t.setName(team);
        t.setWinsCount(1);
        t.setLossCount(0);
        teams.add(t);
    }
}

private void addLoser(String team, List<Team> teams)
{
    int index = 0;
    for(index = 0; index<teams.size(); index++)
    {
        Team t = teams.get(index);
        if(t.getName().equalsIgnoreCase(team))
        {
            // Team already exists, so just increment its loss count.
            t.setLossCount(t.getLossCount() + 1);
            break;
        }
    }

    if(index == teams.size())
    {
        // team not found , then add new team to the list
        Team t = new Team();
        t.setName(team);
        t.setWinsCount(0);
        t.setLossCount(1);
        teams.add(t);
    }
}