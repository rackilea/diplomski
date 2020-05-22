public class Countdown implements Runnable{

    public Countdown(){}

    public void run(){
        try{
            //so let's start counting
            for(int i = 30; i > 0; i--){
                Thread.sleep(1000);
                System.out.println(i);
            }
              System.out.println("TIMEOUT");
        }catch(InterruptedException e){
            System.out.println("Countdown interrupted");
        }


    }
}