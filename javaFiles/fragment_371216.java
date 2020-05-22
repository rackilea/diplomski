int rotations = 0;

/**
 * Increment rotations every rotation
 */
void rotate() {
    rotations++;
    if (rotations >= Math.pow(10, 6)) // consider extracting as constant
        rotations = 0; // reset
}