public static void main(String[] args) {
    char[] array1 = new char[] {'a', 'b', 'c', 'd', 'e', 'y', 'z'};
    char[] array2 = new char[] {'a', 'a', 'a', 'a', 'a', 'a', 'a'};
    char[] array3 = new char[array1.length];

    for (int i = 0; i < array1.length; i++) {
      array3[i] = toChar((toInt(array1[i]) + toInt(array2[i]) + 1) % 26);
    }
    System.out.println(Arrays.toString(array3));
}

private static int toInt(char chr) {
    return chr - 'a';
}

private static char toChar(int value) {
    return (char)(value + 'a');
}