int width = 0;
int height = 0;
int maxHeight = image.getHeight();

for (int embeddedBits = 0; embeddedBits < NumberBitsInMessage; ) {
    int pixel = image.getPixel(width, height);
    int red = Color.red(pixel);
    int green = Color.green(pixel);
    int blue = Color.blue(pixel);

    /*
    modify pixel logic here
    don't forget to increase `embeddedBits` for each colour you modify
    */
    image.setPixel(width, height, Color.argb(Color.alpha(pixel), red, green, blue));

    height++;
    if (height == maxHeight) {
        width++;
        height = 0;
    }
}