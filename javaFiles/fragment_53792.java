protected void paint(Graphics graphics) {


    graphics.drawBitmap( 0, 0, backgroundImage.getWidth(), backgroundImage.getHeight(), backgroundImage, 0, 0 );

    graphics.setColor(Color.WHITE);
    graphics.drawText(text, offset, 0);

    Bitmap b = Bitmap.getBitmapResource("overlay.png");
    graphics.drawBitmap( 0, 0, b.getWidth(), b.getHeight(), b, 0, 0 );

}