import java.io.IOException;
import java.util.*;

public class TimersTask extends TimerTask{
    @Override
    public void run() {
        SimpleRead.os.print("W");
        try {           
            String returnvalue = SimpleRead.is.readLine(); 
            System.out.println(returnvalue);
            GUI.jTextField1.setText(returnvalue); 
            Thread.sleep(1000);
            //is.readLine(); // Second read will remove the extra line feed that AT generates as 
        } catch (IOException e){    
        } catch (InterruptedException e) {    
        }
    }
}