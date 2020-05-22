public class TestMain{

  public static void main(String[] args){

          Thread t = new Thread(new MyTest());
          t.start();
   }
}