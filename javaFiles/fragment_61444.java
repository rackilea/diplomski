import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.AbstractSpinnerModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @see https://stackoverflow.com/a/13121724/230513
 * @see https://stackoverflow.com/a/9758714/230513
 */
public class HexSpinnerTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }

    private static void display() throws HeadlessException {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSpinner sp = new JSpinner(new LongNumberModel(0x8000L, 0x8000L, 0xFFFFL, 1L));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) sp.getEditor();
        JFormattedTextField tf = editor.getTextField();
        tf.setFormatterFactory(new MyFormatterFactory());
        f.getContentPane().add(sp, BorderLayout.NORTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class LongNumberModel extends AbstractSpinnerModel {

        private Long value, stepSize;
        private Comparable<Long> minimum, maximum;

        public LongNumberModel(Long value, Long minimum, Long maximum, Long stepSize) {
            this.value = value;
            this.minimum = minimum;
            this.maximum = maximum;
            this.stepSize = stepSize;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setValue(Object value) {
            this.value = (Long) value;
            fireStateChanged();
        }

        @Override
        public Object getNextValue() {
            long v = value.longValue() + stepSize.longValue();
            return bounded(v);
        }

        @Override
        public Object getPreviousValue() {
            long v = value.longValue() - stepSize.longValue();
            return bounded(v);
        }

        private Object bounded(long v) {
            if ((maximum != null) && (maximum.compareTo(v) < 0)) {
                return null;
            }
            if ((minimum != null) && (minimum.compareTo(v) > 0)) {
                return null;
            }
            return Long.valueOf(v);
        }
    }

    private static class MyFormatterFactory extends DefaultFormatterFactory {

        @Override
        public AbstractFormatter getDefaultFormatter() {
            return new HexFormatter();
        }
    }

    private static class HexFormatter extends DefaultFormatter {

        @Override
        public Object stringToValue(String text) throws ParseException {
            try {
                return Long.valueOf(text, 16);
            } catch (NumberFormatException nfe) {
                throw new ParseException(text, 0);
            }
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            return Long.toHexString(
                ((Long) value).intValue()).toUpperCase();
        }
    }
}