import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 * @see https://stackoverflow.com/a/37899883/230513
 * @see https://stackoverflow.com/q/25501373/230513
 */
public class HighlightTest {

    private static class HighlightEvaluator implements IDateEvaluator {

        private final List<Date> list = new ArrayList<>();

        public void add(Date date) {
            list.add(date);
        }

        @Override
        public boolean isSpecial(Date date) {
            return list.contains(date);
        }

        @Override
        public Color getSpecialForegroundColor() {
            return Color.red.darker();
        }

        @Override
        public Color getSpecialBackroundColor() {
            return Color.blue;
        }

        @Override
        public String getSpecialTooltip() {
            return "Highlighted event.";
        }

        @Override
        public boolean isInvalid(Date date) {
            return false;
        }

        @Override
        public Color getInvalidForegroundColor() {
            return null;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return null;
        }

        @Override
        public String getInvalidTooltip() {
            return null;
        }
    }

    private void display() {
        JFrame f = new JFrame("Highlight Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HighlightEvaluator evaluator = new HighlightEvaluator();
        evaluator.add(createDate(14));
        evaluator.add(createDate(15));
        JCalendar jc = new JCalendar();
        jc.getDayChooser().addDateEvaluator(evaluator);
        jc.setCalendar(jc.getCalendar());
        f.add(jc);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private Date createDate(int d) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, d);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return (c.getTime());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new HighlightTest()::display);
    }
}