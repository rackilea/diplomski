static int getRandomIndex(Random rand, int size, Integer... excludes) {
    List<Integer> excludeList = Arrays.asList(excludes);
    int number;
    do {
        number = rand.nextInt(size);
    } while (excludeList.contains(number));

    return number;
}