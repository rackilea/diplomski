Color[] encode(int[] unsignedBytes) {
    Color[] colors = new Color[unsignedBytes.length / 3];

    for(int i = 0, position = 0; i < colors.length; i++) {
        int r = unsignedBytes[position++];
        int g = unsignedBytes[position++];
        int b = unsignedBytes[position++];

        colors[i] = new Color(r, g, b);
    }

    return colors;
}