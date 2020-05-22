import java.io.Serializable;

class DataMatrix implements Serializable
{

  Square[][][] dataMatrix;

  DataMatrix()
  { 
      dataMatrix = new Square[5][32][32];
  }

  public void setSquare(int x, int y, int z, int c, String type)
  {

     dataMatrix[z][x][y].setSquare(c,type);   

  }
}