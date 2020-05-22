if (firstTime) {
    for (z = 0; z < utenti.length; z++) {
        utenti[z] = rand.nextInt(1000) + 1;
    }
    firstTime = false;
}