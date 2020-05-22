class Main{
  private int currentGridPosX = 5, 
              currentGridPosY = 10;

  public static void main(String[] a){
    Main m = new Main();
    m.test();
  }

  private void test(){
    int x, y;
    x = getCurrentGridPosition()[0];
    y = getCurrentGridPosition()[1];
    System.out.print("x: "+x+"; y: "+y);
  }

  public int[] getCurrentGridPosition()
  {        
    return new int[]{currentGridPosX, currentGridPosY};
  }
}