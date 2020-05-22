private createImage(int width, int height, int imageType) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.imageTypeToBitmapConfig(imageType);
        options.inMutable=true;
        this.bitmap = Bitmap.createBitmap(width, height, options);
}