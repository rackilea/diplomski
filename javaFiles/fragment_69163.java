public class MyThread extends Thread{
      @Override
      public void run(){
          //your code to implement the contents of run() method
      }
 }



public class Main{
    public static void main(String[]args){
        for(int i=0; i<4; i++){
             new MyThread().start()
        }
    }
}