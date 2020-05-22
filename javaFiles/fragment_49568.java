public static void main(String[] args) {
    int numberOfPeople = 4;
    int[] moves = new int[]{3, 2, 1, 3};
    int[] positions = new int[numberOfPeople];

    Arrays.fill(positions, 1);

    int positionsOccupied;

    do {
        positionsOccupied = positionsOccupied(positions);
        positions = dance(positions, moves);

    } while (positionsOccupied(positions) < positionsOccupied);

    System.out.println("Result: " + positionsOccupied(positions));
}

public static int[] dance(int[] oldPositions, int[] moves) {
    int[] newPositions = new int[oldPositions.length];

    for (int i = 0; i < oldPositions.length; i++) {
        newPositions[moves[i] - 1] += oldPositions[i];
    }

    return newPositions;
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