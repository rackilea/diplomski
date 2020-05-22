public int search(long number) {

    int steps = 0;
    long initialNumber = number;
    while (number != 1) {
        if (number % 2 == 0) number /= 2;
        else number = 3 * number + 1
        steps++;

        if (foundNumbers.containsKey(number)) {
            steps += foundNumbers.get(number)
            foundNumbers.put(initialNumber, steps);
            return steps;
        }
    }

    foundNumbers.put(initialNumber, steps);
    return steps;

}