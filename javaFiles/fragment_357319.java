public class VisualComponent extends JComponent{
private static final long serialVersionUID = 1L;

//Constants
public static final int DEFAULT_ZOOM_CHANGE = 10;

//Instance Fields
int pnlWidth, pnlHeight; //The width and height of the panel the image will be painted into
BufferedImage fractalImg;
boolean updateImage;
int[][] fList;

//Constructor
public VisualComponent(int panelWidth, int panelHeight, int[][] list){
    pnlWidth=panelWidth;
    pnlHeight=panelHeight;
    fractalImg = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
    updateImage = true;
    fList=list;
    //also initialize a default color pallet
}

//Methods
public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    Color pixColor;
    for(int x = 0; x<400; x++){
        for(int y=0; y<400; y++){
            if(fList[x][y] >= MandelbrotGenerator.MAX_ITERATIONS){
                fractalImg.setRGB(x, y, Color.BLACK.getRGB());
            } else {
                if(fList[x][y]<=2){
                    pixColor= new Color((42+fList[x][y])%255,0,(80+fList[x][y])%255);
                }else if(fList[x][y]<=3){
                    pixColor= new Color((48+fList[x][y])%255,0,(90+fList[x][y])%255);
                }else {
                    pixColor=new Color((50+fList[x][y])%255,0,(100+fList[x][y])%255);
                }
                fractalImg.setRGB(x, y, pixColor.getRGB());
            }
        }
    }
    g2.drawImage(fractalImg,0,0,this);
}