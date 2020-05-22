import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateChangeEx {

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static int counter = 1;
    public static void main(String[] a){

        Calendar cal = MyCal.getInstance();

        System.out.println(cal.getTime());
        System.out.println("before updating counter--->");
        for(int i=0; i<10; i++){
            System.out.println(""+(counter++)+cal.getTime());
        }

        cal.add(Calendar.DATE, 1);
        System.out.println("After updating counter--->");
        for(int i=0; i<10; i++){
            System.out.println(""+(counter++)+cal.getTime());
        }
        System.out.println(cal.getTime());
    }

    private class ChangeListner implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            counter = 0;

        }

    }

    private class MyCal extends GregorianCalendar{

        public void add(int field, int amount){
            Date oldVal = this.getTime(); 
            super.add(field, amount);

            changeSupport.firePropertyChange("calender", oldVal, this.getTime());
        }
    }

    public void addPropertyChangeListner(PropertyChangeListener listner){
        changeSupport.addPropertyChangeListener(listner);
    }

    public void removePropertyChangeListner(PropertyChangeListener listner){
        changeSupport.removePropertyChangeListener(listner);
    }
}