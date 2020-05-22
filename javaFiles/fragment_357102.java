private void loadImageFromStorage(String path)
{

    try {
        File f = new File(path, "img.jpg");
        Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
        // here is the retrieved image in b
    } 
    catch (FileNotFoundException e) 
    {
        e.printStackTrace();
    }

}