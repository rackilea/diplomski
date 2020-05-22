public static int myFunction(int n, int cat) {
    List<Integer> digits = new ArrayList<Integer>();
    int number = n;
    while (number > 0) {
        digits.add(number % 10);
        number /= 10;
    }
    int finalLength = digits.size() - cat;
    int lastIndex = digits.size();
    int answer = 0;
    for (int i = 0; i < finalLength; i++) {
        int highestDigit = -1;
        for (int j = lastIndex - 1; j >= finalLength - i - 1; j--) {
            if (digits.get(j) > highestDigit) {
                highestDigit = digits.get(j);
                lastIndex = j;
            }
        }
        answer = answer * 10 + highestDigit;
    }
    return answer;
}