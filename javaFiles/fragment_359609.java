public static int myFunction(int n, int cat) {
    String numString = String.valueOf(n);
    int finalLength = numString.length() - cat;
    int[] positions = new int[finalLength];
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < finalLength; i++) {
        for (int j = (i == 0 ? i : positions[i - 1] + 1); j <= numString.length() - finalLength + i; j++) {
            if (positions[i] == 0 || numString.charAt(j) > numString.charAt(positions[i]) ) {
                positions[i] = j;
            }
        }
        answer.append(numString.charAt(positions[i]));
    }
    return Integer.parseInt(answer.toString());
}