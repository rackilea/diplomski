int chosenIndex = 0;
for (int i = 0; i <topTenSongs.length; i ++) {
    log.debug(topTenSongs[i].getTitle());
    if (topTenSongs[i].getTitle().equals("I Gotta Feeling")) {
        chosenIndex = i;
    }
}