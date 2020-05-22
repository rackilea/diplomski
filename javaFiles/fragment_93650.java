import net.rim.device.api.io.http.HttpDateParser;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;

public class StartUp extends UiApplication {
    /**
     * Entry point for application
     */
     public static void main(String[] args) {
         StartUp start=new StartUp();
         start.enterEventDispatcher();

     }
    /**
     * Creates a new StartUp object
     */
    public StartUp() {
        // Push a screen onto the UI stack to have something to render before we attempt

        pushScreen(new DateComparision());



    }
    class DateComparision extends MainScreen
    {
        public DateComparision() 
        {
            String first="31 Jan 2012 23:49:01";//formate should same 
            long time1=HttpDateParser.parse(first)+(4*60*60*1000);//means after 4 hours 
            //time1= 1328068141000
            String second="1 Feb 2012 03:49:01";
            long time2=HttpDateParser.parse(second);
            //time2=1328068141000
            System.out.println(time2+"  "+time1);
            if(time2==time1){
                displayMessage("Mached");
            }else 
            {
                displayMessage("Not Mached");
            }
        }
    }
    public static void displayMessage(final String data){
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                Dialog.inform(data);
            }
        });
    }
}