public static WritableImage pixelScaleAwareCanvasSnapshot(Canvas canvas, double pixelScale) {
    WritableImage writableImage = new WritableImage((int)Math.rint(pixelScale*canvas.getWidth()), (int)Math.rint(pixelScale*canvas.getHeight()));
    SnapshotParameters spa = new SnapshotParameters();
    spa.setTransform(Transform.scale(pixelScale, pixelScale));
    return canvas.snapshot(spa, writableImage);     
}