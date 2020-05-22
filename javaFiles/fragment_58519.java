public boolean isLeather(String playerName) {
    for(String ironPlayerName : getConfig().getStringList("groups.iron")) {
        if(ironPlayerName.equals(playerName)) {
            return false;
        }
    }
    for(String diamondPlayerName : getConfig().getStringList("groups.diamond")) {
        if(diamondPlayerName.equals(playerName)) {
            return false;
        }
    }
    return true;
}