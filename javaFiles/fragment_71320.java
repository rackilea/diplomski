public class FirstCircleRepaintThread extends Thread{


    public static final long SPEED_OF_ROTATING = 25L;

    @Override
    public void run(){
        //while(true){

            MainCycle.frame.panel.startAngleFirst = 34;
            int i = 0;

            Random r = new Random();

            // To infinity and beyond...                
            while(true){