public static float calcFeetAndInchesToCentimeters(int inches) {
    if (inches >= 0) {
        return ((float) inches) / 12;
    } else {
        return -1;
    }
}