public static void main(String[] args){
    Timer timer = new Timer(); //create a new timer
    timer.schedule(new TaskLoop(), 1000); //schedule the task for 1000ms (1 sec)
}
class TaskLoop extends TimerTask {
    public void run() {
        System.out.println("here"); //timer's up, do whatever you need to do
        Timer timer = new Timer();
        timer.schedule(new TaskLoop(), 1000); //start another timer.
    }
}