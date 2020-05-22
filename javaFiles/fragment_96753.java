public int getMove() {
    int direction;
    if (count < DIRECTION_ONE_LENGTH) {
        direction = directionOne;
    } else {
        direction = directionTwo;
    }
    ++count;
    if (count == CYCLE_LENGTH) {
        nextCycle();
    }
    return direction;
}