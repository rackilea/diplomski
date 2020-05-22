package org.hierax.ifdl.tags.player;

public final class PlayerSort {
    public static List<Player> sortByRank(List<Player> playerList) {
        Collections.sort(playerList, new PlayerSortByRank());
        return playerList;
    }

    public static List<Player> sortByAlias(List<Player> playerList) {
        Collections.sort(playerList, new PlayerSortByAlias());
        return playerList;
    }
}