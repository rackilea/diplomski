private Bitmap generateKaleidoscopeBitmap(float start_angle) {

    Canvas canvas = new Canvas(imageview_bitmap);
    canvas.drawColor(Color.BLACK);
    BitmapShader fillShader;

    Path triangle_mask    = new Path();
    RectF r               = new RectF(0, 0, imageview_bitmap.getWidth(), imageview_bitmap.getHeight()); // create new rectangle to match the dimensions of our image

    int centerX = imageview_bitmap.getWidth() / 2;
    int centerY = imageview_bitmap.getHeight() / 2;

    // how much to rotate the canvas by after the image is flipped
    float offset = calculateCanvasSymmetryOffset(start_angle);


    // Create a pie-slice shaped clipping mask
    triangle_mask.moveTo(r.centerX(), r.centerY());
    triangle_mask.arcTo(r, start_angle, angle);
    triangle_mask.close();


    // Fill the triangle masked area with our shader now
    Paint fill = new Paint();
    fill.setColor(0xFFFFFFFF);
    fill.setStyle(Paint.Style.FILL);
    fillShader = new BitmapShader(source_image, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
    fill.setShader(fillShader);


    // Rotate the canvas and draw the clipping mask to the canvas
    for (int i = 0; i < this.segments / 2; i++) {

        canvas.drawPath(triangle_mask, fill);
        canvas.rotate(angle * 2, centerX, centerY);
    }


    // mirror the canvas and rotate it once to counter the symmetrical offset
    canvas.scale(-1, 1, centerX, centerY);
    canvas.rotate(offset, centerX, centerY);


    // Rotate the now mirrored canvas and draw the clipping mask to it
    // This is a cheap and easy way of creating mirrored segments
    for (int i = 0; i < this.segments / 2; i++) {

        canvas.drawPath(triangle_mask, fill);
        canvas.rotate(angle * 2, centerX, centerY);
    }

    return imageview_bitmap;
}