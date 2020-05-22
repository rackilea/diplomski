import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thamira
 */
public class Demostra {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println("Creating object :" + sdf.format(cal.getTime()));
        Object obj = new Object() {

            @Override
            protected void finalize() throws Throwable {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println("The object has removed for : " + sdf.format(cal.getTime()));

                super.finalize(); //To change body of generated methods, choose Tools | Templates.
            }

        };

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println("The object has existed for : " + sdf.format(cal.getTime()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demostra.class.getName()).log(Level.SEVERE, null, ex);
        }

        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println("The object has existed for  : " + sdf.format(cal.getTime()));

        obj = null;

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demostra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}