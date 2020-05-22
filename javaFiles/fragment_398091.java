faces.add(new FaceObj(Bitmap.createBitmap(largeSource, 100, 40, 20, 30), 100, 40);

...

foreach(FaceObj f : faces)
    canvas.drawBitmap(f.bitmap, f.x, f.y, facePaint);