public static Image loadImage(String path, boolean inJar)
{
    Image newImage = null;

    try
    {
        if(inJar)
        {
            newImage = new Image(null, YOUR_MAIN_CLASS.class.getClassLoader().getResourceAsStream(path));
        }
        else
        {
            newImage = new Image(null, path);
        }
    }
    catch(SWTException ex)
    {
        System.out.println("Couldn't find " + path);
        e.printStackTrace();
    }

    return newImage;
}