int moveTime = 1000;

Timer timer = new Timer();

public Bot(){
    timer.schedule(new Task(), moveTime);
}

public class Task extends TimerTask {
    @Override
    public void run() {
        System.out.println("Time Passed from last repeat:"+movetime)
        moveTime += 1000;
        timer.schedule(new Task(), moveTime)
    }
}