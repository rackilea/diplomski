embedding:
for (int i = 0; i < image.getWidth(); i++) {
    for (int j = 0; j < image.getHeight(); j++) {
        if (NumberBitsInMessage == 0) {
            break embedding;
        }

        int pixel = image.getPixel(i, j);
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);

        /*
        modify pixel logic here
        */
        image.setPixel(i, j, Color.argb(Color.alpha(pixel), red, green, blue));
    }
}