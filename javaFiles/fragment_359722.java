File savedPic = new File(picturesDir.getAbsolutePath() + "/mynewpic" + counter + ".jpg");

try {
    out = new FileOutputStream(savedPic);
    resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
    // PNG is a lossless format, the compression factor (100) is ignored

    counter++; // no exception thrown, increment the counter
} catch (Exception e) {
    e.printStackTrace();
}