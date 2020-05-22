private final Map<Integer, Lobby> lobbiesByID;

private boolean isPlayerInLobby(Player player) {
    return lobbiesByID.values().stream().anyMatch(l -> l.hasPlayer(player));
}

public IRemotePublisherForListener connect(Player player, int lobbyID) {
    if(!isPlayerInLobby(player)) {
        //.. insert null-check unless you trust the id
        lobbiesByID.get(lobbyID).addPlayer(player);
    }
    //.. else, log an error, or throw
    return publisher;
}