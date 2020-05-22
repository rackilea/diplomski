public static void addUniqueRandomNumber(List<Integer> numbers, int range) {
    int j = (int)(Math.random()*range);
    if (numbers.contains(j)) {
        addUniqueRandomNumber(numbers, range);
    } else {
        numbers.add(j);
    }
}