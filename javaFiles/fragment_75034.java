public static void removeDuplicates(char[] str) {

    if (str.length < 2) {
        return;
    }

    for (int i = 0; i < str.length; i++) {
        for (int j = 0; j < str.length; j++) {
            System.out.println(i + "-" + j + " = " + str[j]); //added this line
            if ((str[i] == str[j]) && (i != j)) {
                str[j] = 0;
            }
        }
    }
}