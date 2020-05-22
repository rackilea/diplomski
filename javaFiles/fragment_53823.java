String ColorHex="#4EB3A2";

    int RedColor = Integer.parseInt(ColorHex.substring(1,3), 16);
    int GreenColor = Integer.parseInt(ColorHex.substring(3,5), 16);
    int BlueColor = Integer.parseInt(ColorHex.substring(5,7), 16);

    int finalColorValue = 65536 * RedColor + 256*GreenColor + BlueColor;
    int ColorDecimal=finalColorValue;

    // Blue extracted first.
    int blue = ColorDecimal % 256;
    ColorDecimal = (ColorDecimal - blue ) / 256;

    int green = ColorDecimal % 256;
    ColorDecimal = (ColorDecimal - green ) / 256;

    int red = ColorDecimal % 256;
    ColorDecimal = (ColorDecimal - red ) / 256;

    String hex = String.format("#%02x%02x%02x", red, green, blue);
    System.out.println("hex" + hex);