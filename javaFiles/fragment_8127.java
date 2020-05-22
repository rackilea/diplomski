public static Photograph rotated(Photograph photo) {
    Photograph rotated_copy = new Photograph(photo.getHeight(), photo.getWidth());
    Pixel starting_pixel = photo.getPixel(0,0);

    for(int col = 0; col < photo.getWidth(); col++){
        for(int row = 0; row = photo.getHeight(); row++){
            starting_pixel = photo.getPixel(col,row);
            rotated_copy.setPixel(photo.getHeight() - row - 1, col, starting_pixel);
        }
    }
    return rotated_copy;
}