/** Returns a random int in the specified range. */
static int randomInt(float min, float max) {
    if (max < min) {
        max = min;
    }

    int randInt = (int) (new Random(System.nanoTime()).nextInt((int) (max - min + 1)) + min);
    return randInt;
}