for ( int i = 0; i < 4; i++ ) {
    int red = colorModel.getRed(i);
    int green = colorModel.getGreen(i);
    int blue = colorModel.getBlue(i);
    int alpha = colorModel.getAlpha(i);

    System.out.printf("For index %d, red=%d, green=%d, blue=%d, alpha=%d%n", i,red,green,blue,alpha);
}