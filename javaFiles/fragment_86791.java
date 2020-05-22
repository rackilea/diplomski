import java.io.Serializable;
import processing.core.*;

class Square implements Serializable
{

  public int x;
  public int y;
  public int z;
  public int c;
  public String type;

  Square(int xx, int yy, int zz, int cc, String tt){
    x = xx;
    y = yy;
    z = zz;
    c = cc;
    type = tt; 
  }

  public void setSquare(int cc, String tt){

    c = cc;
    type = tt;

  }

  public void printSquare()
  {
     //System.out.println(PApplet.green(c) +"  "+ type);
    int g = (c >> 8) & 0xFF;   // Faster way of getting green(argb)
    System.out.println(g); 
  }

}