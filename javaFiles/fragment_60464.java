// ExampleDatePickerWithoutDay class:

import java.text.*;
import javax.swing.*;
import org.jdatepicker.*;

public class ExampleDatePickerWithoutDay {
    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExampleDatePickerWithoutDay().createAndShowGui();
            }
        });
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        // Set two date formats and a text label.
        DateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        ComponentFormatDefaults.Key formatKey;
        formatKey = ComponentFormatDefaults.Key.SELECTED_DATE_FIELD;
        ComponentFormatDefaults.getInstance().setFormat(formatKey, dateFormat);
        formatKey = ComponentFormatDefaults.Key.TODAY_SELECTOR;
        ComponentFormatDefaults.getInstance().setFormat(formatKey, dateFormat);
        ComponentTextDefaults.Key textKey = ComponentTextDefaults.Key.TODAY;
        ComponentTextDefaults.getInstance().setText(textKey, "Current month");

        // Create the date picker.
        UtilCalendarModel calendarModel = new UtilCalendarModel();
        CustomDatePanel datePanel = new CustomDatePanel(calendarModel);
        CustomDatePicker datePicker = new CustomDatePicker(datePanel);

        panel.add(datePicker);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}