public class Clock implements Runnable{

    private int seconds;
    private int minutes;
    private int hours;
    private String printableSeconds;
    private String printableMinutes;
    private String printableHours;
    public boolean shouldStop;
    public Clock() {}

    public void run() {   // Notice how I changed this to run
        shouldStop = false;
        while (shouldStop == false) {
            wait(1000);
            icrementSeconds();
            printableSeconds = "" + seconds;
            if (seconds < 10) addZeroBeforeSeconds();
            printableMinutes = "" + minutes;
            if (minutes < 10) addZeroBeforeMinutes();
            printableHours = "" + hours;
            if (hours < 10) addZeroBeforeHours();
            if (seconds == 60) {
                icrementMinutes();
            }
            if (minutes == 60) {
                icrementHours();
            }
            printTime();
            System.out.println(shouldStop);
        }
    }
    public void stop() {
        shouldStop = true;
    }

    //yourcode
}