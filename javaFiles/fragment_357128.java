class MyCanvas extends JComponent
{
    public static Image loadImage(String s)
    {
        try 
        {
            return ImageIO.read(Main.class.getResource(s));
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;
        }
    }
}