/**
 * dial can be from 1 .. 6 (where dial 1 moves every rotation)
 */
int getDialPosition(int dial) {
    int pow = Math.pow(10, dial);
    return Math.floor((rotations % pow) / (pow / 10));
    // above gets the digit at position dial
}