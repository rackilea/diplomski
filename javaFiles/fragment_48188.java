public String[] randomArrayString(int length, int numberOfChar) {
    Random random = new Random();
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    String[] array = new String[length];
    String str;
    for (int i = 0; i < length; i++) {
        str = "";
        for (int j = 0; j < numberOfChar; j++) {
            str+= chars[random.nextInt(chars.length - 1)];
        }
        array[i] = str;
    }
    return array;
}