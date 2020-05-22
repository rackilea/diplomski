Random random = new Random();

int length = 1000;
float maxMisplaced = 0.1f;

int[] data = IntStream.range(1000).toArray();
float misplaced = 0;

while (misplaced / length < maxMisplaced) {

    int randIndex1 = random.nextInt(length);
    int randIndex2 = random.nextInt(length);
    if (randIndex1 == randIndex2) continue;

    int randValue1 = data[randIndex1];
    int randValue2 = data[randIndex2];
    data[randIndex1] = randValue2;
    data[randIndex2] = randValue1;

    // increment if it was moved from its starting spot
    if (randIndex1 == randValue1) {
        misplaced += 1;
    }
    if (randIndex2 == randValue2) {
        misplaced += 1;
    }

    // decrement if it was moved back to its starting spot
    if (randIndex1 == randValue2) {
        misplaced -= 1;
    }
    if (randIndex2 == randValue1) {
        misplaced -= 1;
    }
}