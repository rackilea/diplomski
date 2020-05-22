private List<Bitmap> splitBitmap(File file, int everyPixel)
{
    Bitmap comicBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
    List<Bitmap> segments = new ArrayList<>();

    if(comicBitmap == null)
        return segments;

    int height = comicBitmap.getHeight();
    int width = comicBitmap.getWidth();

    for(int i = 0; i < height; i += everyPixel)
    {
        i = i >= height? height : i;
        int limit = i + everyPixel >= height? height - i : everyPixel;

        Bitmap bitmap = Bitmap.createBitmap(comicBitmap, 0, i, width, limit);
        segments.add(bitmap);
    }

    return segments;
}