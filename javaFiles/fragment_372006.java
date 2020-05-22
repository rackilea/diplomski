public class DisplayBitmaps extends UiApplication
{
    public static void main(String[] args)
    {
        DisplayBitmaps theApp = new DisplayBitmaps();       
        theApp.enterEventDispatcher();
    }

    public DisplayBitmaps()
    {        
        pushScreen(new DisplayBitmapsScreen());
    }    
}

final class DisplayBitmapsScreen extends MainScreen
{
    DisplayBitmapsScreen()
    {    
     Bitmap bitmap = EncodedImage.getEncodedImageResource("images/image.png").getBitmap();
     BitmapField bitmapField = new BitmapField(bitmap);
        add(bitmapField);
    }

    public void close()
    {  
        super.close();
    }   
}