private final Random rand = new Random();

    public int getRandom(int min, int max, int... excludeNumbers) {
        int random = rand.nextInt(max - min + 1 - excludeNumbers.length) + min;
        for (int exc : excludeNumbers) {
            if (random >= exc) {
                random++;
            }
        }
        return random;
    }