public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
    int random = start + rnd.nextInt(end - start + 1 - exclude.length);
    for (int ex : exclude) {
        if (random < ex) {
            break;
        }
        random++;
    }
    return random;
}