public static void main(String[] args) {
    int numberOfPeople = 4;
    int[] moves = new int[]{3, 2, 1, 3};
    int[] positions = new int[numberOfPeople];

    Arrays.fill(positions, 1);

    int[] snapshot;

    do {
        snapshot = Arrays.copyOf(positions, positions.length);

        dance(positions, moves);
    } while (!Arrays.equals(positions, snapshot));

    System.out.println("Result: " + positionsOccupied(positions));
}

public static void dance(int[] positions, int[] moves) {
    for (int i = 0; i < positions.length; i++) {
        int currentNumber = positions[i];
        positions[i] = 0;
        positions[moves[i] - 1] += currentNumber;
    }
}

public static int positionsOccupied(int[] positions) {
    int result = 0;

    for (int i = 0; i < positions.length; i++) {
        if (positions[i] > 0) {
            result++;
        }
    }


    return result;
}