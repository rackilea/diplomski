import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class DateEditorTimeZoneTest {
  public JComponent makeUI() {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss,SSS");
    format.setTimeZone(TimeZone.getTimeZone("GMT"));

    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    cal.clear(Calendar.HOUR_OF_DAY);
    cal.clear(Calendar.AM_PM);
    cal.clear(Calendar.HOUR);
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);

    Date start = cal.getTime();
    System.out.println(start);
    System.out.println(format.format(start));

    int defaultStep = 100;
    JSpinner spinner = new JSpinner(new SpinnerDateModel(
            start, null, null, Calendar.MILLISECOND) {
      @Override public void setCalendarField(int calendarField) {
        // If you only want one field to spin you can subclass
        // and ignore the setCalendarField calls. 
      }
      @Override public Object getNextValue() {
        Object next = super.getValue();
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime((Date) next);
        Date helper = new Date(calendar.getTimeInMillis() + defaultStep);
        calendar.setTime(helper);
        System.out.println(calendar.getTimeInMillis());
        return calendar.getTime();
      }
      //@Override public Object getPreviousValue() {
      //  //...
      //}
    });
    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss,SSS");
    spinner.setEditor(editor);
    editor.getTextField().setFormatterFactory(
        new DefaultFormatterFactory(new DateFormatter(format)));

    JPanel p = new JPanel();
    p.add(spinner);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new DateEditorTimeZoneTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}