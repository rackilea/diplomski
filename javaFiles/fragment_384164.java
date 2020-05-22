...
import android.graphics.drawable.Drawable;

public class RunningApplication {
     public String processName, pid = "" ;
     public long startTime = 0 ;
     public Drawable processIcon = null ;

     public RunningApplication(String name, long start, String pid, Drawable icon) {
        this.processName = name ;
        this.startTime = start ;
        this.pid = pid ;
        this.processIcon = icon ;
     }

     public getProcessName() {
        return processname ;
     }

     ...

}