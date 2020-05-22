import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        NumberFormat format = DecimalFormat.getInstance();
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(5);
        format.setRoundingMode(RoundingMode.HALF_UP);
        InternationalFormatter formatter = new InternationalFormatter(format);
        formatter.setAllowsInvalid(false);

        JFormattedTextField field = new JFormattedTextField(formatter);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(field);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}