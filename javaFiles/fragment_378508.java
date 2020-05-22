public class Cell {

     private int x;
     private int y;
     private OccupationInfo occupationInfo;

     public int posX() {
         return x;
     }

     public int posY() {
        return y;
     }

     public OccupationInfo getOccupationInfo() {
        return occupationInfo;
     }

     public boolean isFree() {
        return occupationInfo == null;
     }
  }