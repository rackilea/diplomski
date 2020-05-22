public class util {

    private int method(int x,int y){
      return x + y;
    }

    private int method2(int x,int y){
      return x + y;
    }

    public void result(int x,int y){
      System.out.println("Result: " + ( method(x, y) + method2(x, y) ));
    }
}