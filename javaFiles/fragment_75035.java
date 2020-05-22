public static void main(String[] args) {
    char[] chr = {'a','a','b','c','b','a','b','c'};
    System.out.println(removeDuplicates(chr));
}

public static char[] removeDuplicates(char[] str) {
    if (str.length < 2) {
        return null;
    }
    for (int i = 0; i < str.length; i++) {
        for (int j = 0; j < str.length; j++) {
            if ((str[i] == str[j]) && (i != j)) {
                str[j] = 0;
            }
            if (i == (str.length-1)) {
                str[i] = str[j];
            }
        }
    }
    return str;
}