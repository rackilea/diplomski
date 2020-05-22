private Bitmap loadAugmentedImage(String file)
    {
        try (InputStream is = new FileInputStream (file))
        {
            return BitmapFactory.decodeStream(is);
        }
        catch (IOException e)
        {
            Log.e("loadAugmentedImage", "IO Exception", e);
        }
        return null;
    }