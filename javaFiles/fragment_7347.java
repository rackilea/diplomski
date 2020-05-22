public int sum67(int[] arr) {
    int sum = 0;
    boolean isIn67 = false;
    for (int i = 0 ; i < arr.length ; i++) {
        if (arr[i] == 6) {
            isIn67 = true;
            continue;
        } else if (arr[i] == 7 && isIn67) {
            isIn67 = false;
            continue;
        }
        if (!isIn67) {
            sum += arr[i];
        }
    }
    return sum;
}