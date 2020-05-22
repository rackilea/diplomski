private void rotateCursor(double rotation) {
    // Get the default toolkit
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    // Load an image for the cursor
    BufferedImage image = null;
    try {
        image = ImageIO.read(this.getClass().getResource("/data/cursor.png"));
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    AffineTransform at = new AffineTransform(); 
    // affineTransform applies the added transformations in the reverse order

    // 3. translate it back to the center of the picture
    at.translate(image.getWidth() / 2, image.getWidth() / 2);

    at.rotate(rotation);//2- adds rotation  to at (they are not degrees)

    //1- translate the object so that you rotate it around the center
    at.translate(-image.getWidth() / 2, -image.getHeight() / 2);

    BufferedImage rotated = null; // creates new image that will be the transformed image

    // makes this: at + image= rotated
    AffineTransformOp affineTransformOp = new AffineTransformOp(at,
            AffineTransformOp.TYPE_BILINEAR);
    image2 = affineTransformOp.filter(image, rotated);

    // Create the hotSpot for the cursor
    Point hotSpot = new Point(10, 0); // click position of the cursor(ex: + shape's is middle)

    Cursor cursor = toolkit.createCustomCursor(rotated, hotSpot, "cursor");

    // Use the custom cursor
    this.setCursor(cursor);

}