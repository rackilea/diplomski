public static int myStringToInteger(String str) {
    int answer = 0, factor = 1;
    for (int i = str.length()-1; i >= 0; i--) {
        answer += (str.charAt(i) - '0') * factor;
        factor *= 10;
    }
    return answer;
}