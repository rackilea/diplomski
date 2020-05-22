ArrayList<FootballClub> originalLeagueList = new ArrayList<FootballClub>();

originalLeagueList.add(new FootballClub(1, "Arsenal", 35, 11, 2, 2, 15, 30, 11, 19));
originalLeagueList.add(new FootballClub(2, "Liverpool", 30, 9, 3, 3, 15, 34, 18, 16));
originalLeagueList.add(new FootballClub(3, "Chelsea", 30, 9, 2, 2, 15, 30, 11, 19));
originalLeagueList.add(new FootballClub(4, "Man City", 29, 9, 2, 4, 15, 41, 15, 26));
originalLeagueList.add(new FootballClub(5, "Everton", 28, 7, 1, 7, 15, 23, 14, 9));
originalLeagueList.add(new FootballClub(6, "Tottenham", 27, 8, 4, 3, 15, 15, 16, -1));
originalLeagueList.add(new FootballClub(7, "Newcastle", 26, 8, 5, 2, 15, 20, 21, -1));
originalLeagueList.add(new FootballClub(8, "Southampton", 23, 6, 4, 5, 15, 19, 14, 5));

for (int i = 0; i < originalLeagueList.size(); i++){
   int position = originalLeagueList.get(i).getPosition();
   String name = originalLeagueList.get(i).getName();
   int points = originalLeagueList.get(i).getPoinst();
   int wins = originalLeagueList.get(i).getWins();
   int defeats = originalLeagueList.get(i).getDefeats();
   int draws = originalLeagueList.get(i).getDraws();
   int totalMatches = originalLeagueList.get(i).getTotalMathces();
   int goalF = originalLeagueList.get(i).getGoalF();
   int goalA = originalLeagueList.get(i).getGoalA();
   in ttgoalD = originalLeagueList.get(i).getTtgoalD();

   Object[] data = {position, name, points, wins, defeats, draws, 
                               totalMatches, goalF, goalA, ttgoalD};

   tableModel.add(data);

}