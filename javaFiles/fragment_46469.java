@SessionScoped
public class ImageBean implements Serializable 
{
    private static final long serialVersionUID = 1L;
    ArrayList<Image> myArr = new ArrayList<Image>();
    BufferedImage img = null;

    private int currImgId = 1;

    public ImageBean()
    {
        for(int i = 1; i < 10; i++)
        {
            try 
            {
                img = ImageIO.read(new File(i + ".jpg"));
            } 
            catch (IOException ex) {}

            myArr.add(img);
        }
    }

  public BufferedImage getImage() 
  {
    // Reset logic would go here...probably best with array.size...
    return (BufferedImage) myArr.get(currImgId++);
  }

}