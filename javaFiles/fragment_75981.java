public static void main(String[] args) {
    String[] strings = new String[]{"first", "second"};
    System.out.println(Arrays.toString(strings));
    byte[][] byteStrings = convertToBytes(strings);
    strings = convertToStrings(byteStrings);
    System.out.println(Arrays.toString(strings));

}

private static String[] convertToStrings(byte[][] byteStrings) {
    String[] data = new String[byteStrings.length];
    for (int i = 0; i < byteStrings.length; i++) {
        data[i] = new String(byteStrings[i], Charset.defaultCharset());

    }
    return data;
}


private static byte[][] convertToBytes(String[] strings) {
    byte[][] data = new byte[strings.length][];
    for (int i = 0; i < strings.length; i++) {
        String string = strings[i];
        data[i] = string.getBytes(Charset.defaultCharset()); // you can chose charset
    }
    return data;
}