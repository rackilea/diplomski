public class solar
{
  public static void main(String args[])
    int i = 0;
    {
       while (true) {

          SolarSystem x = new SolarSystem(500,500);
          x.drawSolarObject(0,0,50,"YELLOW");
          x.drawSolarObject(90,i,20,"BLUE");

          i++;

          x.finishedDrawing();

    }
  }
}