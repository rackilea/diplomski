import javax.swing.*;
import java.text.DecimalFormat;

public class JNumberButton extends JButton {
    private static final DecimalFormat format = new DecimalFormat("#");
    private double number;

    public JNumberButton(double number) {
        super(format.format(number));
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        setText(format.format(number));
        this.number = number;
    }
}