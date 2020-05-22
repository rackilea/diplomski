public boolean isLeather(String playerName) {
    for(String leatherPlayerName : getConfig().getStringList("groups.leather")) {
        if(leatherPlayerName.equals(playerName)) {
            return true;
        }
    }
    return false;
}

public boolean isIron(String playerName) {
    for(String ironPlayerName : getConfig().getStringList("groups.iron")) {
        if(ironPlayerName.equals(playerName)) {
            return true;
        }
    }
    return false;
}

public boolean isDiamond(String playerName) {
    for(String diamondPlayerName : getConfig().getStringList("groups.diamond")) {
        if(diamondPlayerName.equals(playerName)) {
            return true;
        }
    }
    return false;
}