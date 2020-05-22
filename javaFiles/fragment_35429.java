public class Tests {
    public static void main(String args[]) {
        try {
            Timer tmr = detectHangingAndKillProject(30,false);
            Process p = Runtime.getRuntime().exec("command to run");
            tmr.cancel();
            tmr.purge();
            ..
            .. 
        }
    }
}

public static Timer detectHangingAndKillProject(int seconds){
    Timer tmr=new Timer();
    Tests t=new Tests();
    tmr.schedule(t.new ReminderTask(), seconds*10000);
    return tmr;
}