public static String pick(String message, int n) {
    int index = 0;

    for (int i = 1; i < n; i++) {
        while (index < message.length() && message.charAt(index) != ' ') index++;
        while (index < message.length() && message.charAt(index) == ' ') index++;
    }

    int start = index;
    while (index < message.length() && message.charAt(index) != ' ') index++;

    return message.substring(start, index);
}