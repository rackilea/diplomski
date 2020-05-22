public static int consecutiveLetters(String[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        char ch1, ch2;
        double numberOfDuplicates = 0, word = 0;

        for (int j = 0; j < arr[i].length()-1; j++) {
            ch1 = arr[i].charAt(j);
            ch2 = arr[i].charAt(j + 1);
            if (ch1 == ch2) {
                numberOfDuplicates++;
            }
            if(Character.isUpperCase(arr[i].charAt(j))) {
                word += (int) arr[i].charAt(j) - 64;
            } else {
                word += (int) arr[i].charAt(j) - 96;
            }
        }
        word += ((int) arr[i].charAt(arr[i].length()-1) - 96);

        if(numberOfDuplicates > 0) {
             double num = Math.pow(2, numberOfDuplicates);
             word = word * num;
        }
        sum += word;
    }
    return sum;

}