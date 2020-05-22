private boolean containList(float x, float y) {
    for (Float[] coordinate : list) {
        float coordinateX = coordinate[0];
        float coordinateY = coordinate[1];

        if (coordinateX == x && coordinateY == y) {
            return true;
        }
    }
    return false;  // (x, y) not found
}