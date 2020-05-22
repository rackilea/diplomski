public static void main(String[] args) {
    String userInput = "Peter";
    int length = userInput.length();
    int m, j, i, n = 0;
    for (m = length % 2 > 0 ? 1 : 2; m < length * 2; m += 2) {
        i = m < length ? m : length * 2 - m;
        for (j = 0; j < length - 1 - i / 2; ++j) {
            System.out.print(" ");
        }

        for(j = 0; j < i; ++j) {
            char c = userInput.charAt(n++ % length);
            c = j == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
            System.out.print(c);
        }

        System.out.println("");
    }
}