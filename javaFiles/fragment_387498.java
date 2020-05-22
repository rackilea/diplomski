public class WritePdfActivity extends Activity 
{
  private static String FILE = "mnt/sdcard/FirstPdf.pdf";

  static Image image;
  static ImageView img;
  Bitmap bmp;
  static Bitmap bt;
  static byte[] bArray;

  @Override
public void onCreate(Bundle savedInstanceState) 
{   
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    img=(ImageView)findViewById(R.id.imageView1);

    try 
    {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();

        addImage(document);
        document.close();
    }

    catch (Exception e) 
    {
        e.printStackTrace();
    }

}
  private static void addImage(Document document) 
  {

    try 
    {
        image = Image.getInstance(bArray);  ///Here i set byte array..you can do bitmap to byte array and set in image...
    } 
    catch (BadElementException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (MalformedURLException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (IOException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     // image.scaleAbsolute(150f, 150f);
      try 
      {
        document.add(image);
    } catch (DocumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
 }
 }