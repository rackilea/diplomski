static void nameSwitch(int[] array, int pos1, int pos2) {

    if (pos1 < pos2) {
        return;
    }

    int temp = array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = temp;

}