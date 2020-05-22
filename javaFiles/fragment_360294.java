// void return type as it shifts in-place
private static void shiftArray(int[] array, int stepSize) {
    // TODO: Cope with negative step sizes etc
    int[] tmp = new int[stepSize];
    System.arraycopy(array, array.length - stepSize, tmp, 0, stepSize);
    System.arraycopy(array, 0, array, stepSize, array.Length - stepSize);
    System.arraycopy(tmp, 0, array, 0, stepSize);
}