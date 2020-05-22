float value = (255.0f + amount) / 255.0f;
value *= value;
for(int i = 0; i < ImageSync.previewPixels.length; i++){
    int pixel = ImageSync.previewPixels[i];
    int r = Colors.red(pixel);
    int g = Colors.green(pixel);
    int b = Colors.blue(pixel);

    float red = r / 255.0f;
    float green = g / 255.0f;
    float blue = b / 255.0f;

    red = (((red - 0.5f) * value) + 0.5f) * 255.0f;
    green = (((green - 0.5f) * value) + 0.5f) * 255.0f;
    blue = (((blue - 0.5f) * value) + 0.5f) * 255.0f;

    int iR = (int)red;
    iR = iR > 255 ? 255 : iR;
    iR = iR < 0 ? 0 : iR;
    int iG = (int)green;
    iG = iG > 255 ? 255 : iG;
    iG = iG < 0 ? 0 : iG;
    int iB = (int)blue;
    iB = iB > 255 ? 255 : iB;
    iB = iB < 0 ? 0 : iB;

    ImageSync.previewPixels[i] = Colors.rgba(iR, iG, iB);
}