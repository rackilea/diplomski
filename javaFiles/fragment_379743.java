for (int i = 0; i < dolzina; i++) {
    int randomInt = rGenerator.nextInt(2);
    if (randomInt > 0) {
        beseda.setCharAt(i, '*');
    }
}