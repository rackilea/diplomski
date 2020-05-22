public void checkChance(final String spawnX, final int chance, final int value) {
    int intermediary;

    if (player.getX() > screenWidth / 2) {
        if (chance > value) {
            intermediary = random.nextInt(screenWidth - (screenWidth / 2)) + (screenWidth / 2);
        } else {
            intermediary = random.nextInt((screenWidth / 2) - 0);
        }
    } else {
        if (chance > value) {
            intermediary = random.nextInt((screenWidth / 2) - 0);
        } else {
            intermediary = random.nextInt(screenWidth - (screenWidth / 2)) + (screenWidth / 2);
        }
    }

    if (spawnX.equals("smallX")) {
        smallX = intermediary;
    } else if (spawnX.equals("mediumX")) {
        mediumX = intermediary;
    } else if (spawnX.equals("largeX")) {
        largeX = intermediary;
    }
}