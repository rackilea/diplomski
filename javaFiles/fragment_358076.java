public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
    Random rand = new Random();
    int range = end - start + 1;

    int random = rand.nextInt(range) + 1;
    while(excludeRows.contains(random)) {
        random = rand.nextInt(range) + 1;
    }

    return random;
}