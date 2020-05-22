boolean[][] clicked = {};

void initArray(int gridSize) {

    for (int i = 0; i < gridSize; i++) {
        boolean[] row = {}; // <--- new object for each row
        for (int j = 0; j < gridSize; j++)
            row = (boolean[]) append(row, false);
        clicked = (boolean[][]) append(clicked, row);
    }
}