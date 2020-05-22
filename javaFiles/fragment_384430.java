import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private boolean manualDate;

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JDateChooser dateChooser = new JDateChooser();
                dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (manualDate) {
                            return;
                        }
                        Date newDate = (Date) evt.getNewValue();
                        Date oldDate = (Date) evt.getOldValue();
                        if (newDate != null && oldDate != null) {
                            LocalDate newLD = LocalDate.ofInstant(newDate.toInstant(), ZoneId.systemDefault());
                            LocalDate oldLD = LocalDate.ofInstant(oldDate.toInstant(), ZoneId.systemDefault());
                            if (newLD.equals(oldLD)) {
                                return;
                            }
                        }
                        System.out.println(evt.getPropertyName());
                    }
                });
                manualDate = true;
                dateChooser.setDate(new Date());
                manualDate = false;

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dateChooser);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}