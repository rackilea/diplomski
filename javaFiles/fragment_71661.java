public static String[] remove(String[] array) {
    int len = array.length;
    for (int i = 0; i < len; i++) {
        for (int j = i+1; j < len && j > 0; j++) {
            if(array[i].equals(array[j])){
                String tmp = array[len -1];
                array[len - 1] = array[j];
                array[j] = tmp;
                len--;
                j--;
            }
        }
    }
    return Arrays.copyOf(array, len);
}