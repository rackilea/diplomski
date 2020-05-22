public static void sBoard () {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if(board==null)
        board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("VoteMap", "dummy");
        obj.setDisplayName("Vote for maps!");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score scores[] = new Score[6];

        for (int i = 1; i<6; i++) {
            scores[i] = obj.getScore("Map " + i);
            scores[i].setScore(0);
            this.scores[i] = scores[i];
        }
    }