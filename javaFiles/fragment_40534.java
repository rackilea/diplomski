public static String getNextPalindrome(String number) {
    char[] str = number.toCharArray();

    int front = 0;
    int back = str.length - 1;

    while (front < back) {
        if (str[back] > str[front]) {
          if (back == front + 1) {
            str[front] = str[back];
          } else {
            str[back] = str[front];
            str[back - 1] = (char) (str[back - 1] + 1);
          }
        } else if (str[back] < str[front]) {
          str[back] = str[front];
        }
        front++;
        back--;
    }

    return new String(str);
}