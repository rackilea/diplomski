class Root {

    private Data data;

    // getters, setters, toString
}

class Data {
    LeagueTable[] leagueTable;

    // getters, setters, toString

    public static class LeagueTable{
        String team;
        int played, gamesWon, gamesDraw, gameLost, goalsFor, goalsAgainst, goalsDifference, points;

        // getters, setters, toString
    }
}