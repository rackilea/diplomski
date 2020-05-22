public static String replaceVals(String str) {
    String[] array = str.toCharArray();
    for (int i=0; i<array.length;i++) {
        array[i] = array[i] == 'T' ? 'F' : 'T';
    }
    return new String(array);
}