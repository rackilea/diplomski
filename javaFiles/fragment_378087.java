import java.util.Arrays;

public class TeamDistributor {

    private int[] players;
    private double optimalTeamStrength;

    private int[] bestTeam;//the best team found at the moment
    private double bestTeamStrengthDifference;//the difference between the current best team strength and the optimalTeamStrength

    public static void main(String[] args) {
        int[] players = new int[] {1, 2, 3, 4};
        TeamDistributor distributor = new TeamDistributor(players);
        int[][] teams = distributor.createTeams();//contains the indices of the teams
        printResults(distributor, players, teams);

        System.out.println("\n");
        players = new int[] {2, 2, 3, 3, 4, 4, 1, 1, 2, 2};
        distributor = new TeamDistributor(players);
        teams = distributor.createTeams();
        printResults(distributor, players, teams);

        System.out.println("\n");
        players = new int[] {8, 8, 9, 6, 1, 7, 1, 3, 7, 5};
        distributor = new TeamDistributor(players);
        teams = distributor.createTeams();
        printResults(distributor, players, teams);
    }

    private static void printResults(TeamDistributor distributor, int[] players, int[][] teams) {
        int[][] strengths = distributor.getPlayersStrengthFromIndices(teams);

        System.out.println("Players: " + Arrays.toString(players));
        System.out.println("Team1 (indices): " + Arrays.toString(teams[0]));
        System.out.println("Team2 (indices): " + Arrays.toString(teams[1]));
        System.out.println("Team1 (individual strength): " + Arrays.toString(strengths[0]));
        System.out.println("Team2 (individual strength): " + Arrays.toString(strengths[1]));
        System.out.println("Team1 total strength: " + distributor.getTeamStrength(teams[0]));
        System.out.println("Team2 total strength: " + distributor.getTeamStrength(teams[1]));
    }

    public TeamDistributor(int[] players) {
        this.players = players;

        //calculate the total strength of all players combined
        double totalStrength = 0;
        for (int i : players) {
            totalStrength += i;
        }

        //calculate the optimal strength for a team
        optimalTeamStrength = totalStrength / 2;
    }

    /**
     * Calculates the optimal teams and returns them as int-array (int[2][players.length/2])
     */
    public int[][] createTeams() {
        //assuming players.length is an even number
        int playersPerTeam = players.length / 2;
        //find the optimal team
        bestTeamStrengthDifference = Double.POSITIVE_INFINITY;
        createOptimalTeam(new int[playersPerTeam], 0);

        //the best team1 is in the global variable bestTeam
        //now create team2
        int[] team2 = new int[playersPerTeam];
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            if (!containsPlayer(bestTeam, i)) {
                team2[index] = i;
                index++;
            }
        }

        //return team 1 and 2 as int[2][players/2]
        return new int[][] {bestTeam, team2};
    }

    /**
     * Create all teams and choose the one that is the closest to the optimalTeamStrength.
     */
    private void createOptimalTeam(int[] teamIndices, int playerIndex) {
        if (playerIndex >= teamIndices.length) {
            //no space for more players in this team -> test whether the current team is the best one yet
            int currentTeamStrength = getTeamStrength(teamIndices);
            double currentDifference = Math.abs(currentTeamStrength - optimalTeamStrength);
            if (currentDifference < bestTeamStrengthDifference) {
                bestTeam = teamIndices.clone();
                bestTeamStrengthDifference = currentDifference;
            }
        }
        else {
            //iterate through all possible players for the current index
            for (int i = 0; i < players.length; i++) {
                if (!containsPlayer(teamIndices, i)) {
                    //add a player to the current place
                    teamIndices[playerIndex] = i;
                    //add a player to the next place
                    createOptimalTeam(teamIndices, playerIndex + 1);
                }
            }
        }
    }

    /**
     * Checks whether a team contains a player.
     */
    private boolean containsPlayer(int[] teamIndices, int playerIndex) {
        boolean contains = false;
        for (int i : teamIndices) {
            contains |= i == playerIndex;
        }
        return contains;
    }

    /**
     * Calculates the total strength of a team.
     */
    public int getTeamStrength(int[] teamIndices) {
        int teamStrength = 0;
        for (int i : teamIndices) {
            teamStrength += players[i];
        }
        return teamStrength;
    }

    /**
     * Maps the players indices to the players strength.
     */
    public int[][] getPlayersStrengthFromIndices(int[][] playersIndices) {
        int[][] teamStrengths = new int[2][players.length / 2];

        for (int i = 0; i < teamStrengths.length; i++) {
            for (int j = 0; j < players.length / 2; j++) {
                teamStrengths[i][j] = players[playersIndices[i][j]];
            }
        }

        return teamStrengths;
    }
}