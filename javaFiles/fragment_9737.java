public int guessNumber(int num, int min, int max) {
    if (min == max) {
        return min;
    }
    int middle = (max + min) / 2;
    if (num > middle) {
        return guessNumber(num, middle + 1, max);
    } else {
        return guessNumber(num, min, middle);
    }
}