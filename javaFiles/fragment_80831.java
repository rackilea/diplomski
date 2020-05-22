import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButtons extends JPanel {

    //public static JFrame frame;
    // static is rarely a solution of problems in a GUI. ToDo! Change!
    static JPanel ui = new JPanel(new GridLayout(2, 0, 20, 20));

    private JButton Red = new JButton("Red");
    private JButton Green = new JButton("Green");
    private JButton Blue = new JButton("Blue");

    public void InitializeButton() {
        Blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ui.setBackground(Color.BLUE);
            }
        });

        Green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ui.setBackground(Color.GREEN);
            }
        });

        Red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ui.setBackground(Color.RED);
            }
        });
    }

    public MyButtons() {
        InitializeButton();
        add(Red);
        add(Green);
        add(Blue);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(250, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel row1 = new MyButtons();
        JPanel row2 = new MyButtons();

        //row1.setPreferredSize(new Dimension(250, 100));
        //row2.setPreferredSize(new Dimension(250, 100));

        //frame.setLayout(new GridLayout(3, 2,10,10));
        ui.add(row1);
        ui.add(row2);
        frame.add(ui);
        frame.pack();
        frame.setVisible(true);
    }
}