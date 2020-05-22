import java.awt.*;
import javax.swing.*;

public class Gui_Class {

    JFrame frame;
    JPanel panel;

    public Gui_Class() {
        frame = new JFrame("Suduko");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(9, 9));
        frame.add(panel);
        //panel.setVisible(true); //unnecessary 

        JTextField[][] table = new JTextField[9][9];
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                table[m][n] = new SquareTextField(m + " " + n);
                panel.add(table[m][n]);
            }
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            new Gui_Class();
        };
        SwingUtilities.invokeLater(r);
    }
}

class SquareTextField extends JTextField {

    int size = 30;

    SquareTextField(String s) {
        super(s);
        setFont(getFont().deriveFont((float)size));
        int sz = size/6;
        setMargin(new Insets(sz, sz, sz, sz));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        int w = d.width;
        int h = d.height;
        int max = w>h ? w : h;

        return new Dimension(max, max);
    }
}