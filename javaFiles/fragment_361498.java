@Variable("Primary Class")
public String getHClass(Player p) {
    return getHeroFromPlayer(p).getHeroClass().getName();
}

@Variable("Primary Class Level")
public int getHLevel(Player p) {
    return getHeroFromPlayer(p).getHLevel();
}

@Variable("Secondary Class")
public String getHSecClass(Player p) {
    return getHeroFromPlayer(p).getSecondClass().getName();
}

@Variable("Secondary Class Level")
public int getHLevel(Player p) {
    return getHeroFromPlayer(p).getHSecLevel();
}