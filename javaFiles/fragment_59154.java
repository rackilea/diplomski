int[] decode(Color[] colors) {
    int[] unsignedBytes = new int[colors.length * 3];

    int position = 0;
    for(Color color : colors) {
        unsignedBytes[position++] = color.getRed();
        unsignedBytes[position++] = color.getGreen();
        unsignedBytes[position++] = color.getBlue();
    }

    return unsignedBytes;
}