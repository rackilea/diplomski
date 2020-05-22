public void addMatches(List<WhiteListMatches> matches) {
    for (WhiteListMatches wl : matches) {
        wl.setWhiteList(this);
        this.matches.add(wl);
    }
}