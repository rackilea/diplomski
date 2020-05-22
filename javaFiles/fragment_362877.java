@Override
protected void onDraw(Canvas canvas) {
    canvas.save(Canvas.MATRIX_SAVE_FLAG);
    canvas.rotate(angle, centerX, centerY);
    ...

    // Neutralize the rotation
    correctionMatrix.setRotate(-angle, centerX, centerY);

    // Initialize a float array that holds the original coordinates
    float[] src = {word.getX(), word.getY()};

    // Load transformed values into `src` array
    correctionMatrix.mapPoints(src);

    // `src[0]` and `src[1]` hold the transformed `X` and `Y` coordinates
    canvas.drawText(word.text, src[0], src[1], somePaint);
    ....
    canvas.restore();
}