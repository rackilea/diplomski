HashMap<Player, Scoreboard> boards = new HashMap<>();
HashMap<Player, Objective> objProvider = new HashMap<Player, Objective>() {
    @Override
    get(Player player) {
        if (this.containsKey(player))
            return this.get(player);

        // Lazy initialization
        Scoreboard value = boards.get(player);
        if (value != null)
            return value;
        value = sbm.getNewScoreboard();
        boards.put(player, value);

        // Scoreboard initialization
        Objective obj = board.registerNewObjective("Kill Stats", "playerKillCount");
        obj.setDisplayName("Kill Count");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        this.put(player, obj);

        return value;
    }
};