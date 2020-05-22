private static List<Integer> bitPositions(int number) {
    List<Integer> positions = new ArrayList<>();
    int position = 1;
    while (number != 0) {
        if (number & 1 != 0) {
            positions.add(position);
        }
        position++;
        number = number >>> 1;
    }
    return positions;
}