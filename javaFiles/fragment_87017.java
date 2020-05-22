for (GameStorage gs : gameList) {
    if (gs.getName().contains(query)) {
        temp.add(gs);
    }
}
return temp;