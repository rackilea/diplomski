public void populateArray() {
    List<Integer> pool = new ArrayList<Integer>();
    for (int i = 0; i < 49; ++i) {
        pool.add(i + 1);
    }

    for (int i = 0; i < 6; ++i) {
        randomNumber = randomGen.nextInt(pool.size());
        numberLine[i] = pool.get(randomNumber);
        pool.remove(randomNumber);
    }

    Arrays.sort(numberLine);
}