public char[] sortArray(char[] arr) {
    // Creating a blank string array
    String [] end = new String[arr.length];

    // Converting (char) arr array to (string) end array.
    for(int i = 0; i < arr.length; i++) {
        end[i] = "" + arr[i];
    }

    // Sorts the end array ignoring case
    Arrays.sort(end, String.CASE_INSENSITIVE_ORDER);

    // Converting (string) end array to (char) arr array.
    for(int i = 0; i < arr.length; i++) {
        arr[i] = end[i].charAt(0);
    }

    // Returns arr aray
    return arr;
}