public class TestMain{

    public void go(){

           for(int i=0 ; i<10 ; i++){

             System.out.println("Hello i am work nos "+i);
           }

   }

      public static void main(String[] args){

              Thread t = new Thread(new Runnable(){

              public void run(){

                new TestMain().go();

           }

   });
              t.start();
       }
    }