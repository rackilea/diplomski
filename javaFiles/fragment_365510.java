import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class MyCalculater 
{
    private static final Insets insets = new Insets(0, 0, 0, 0);

    private Frame frame = new Frame("My-Calculator");
    private GridBagConstraints gBagConstraints = new GridBagConstraints();
    private GridBagLayout gBagLayout = new GridBagLayout();
    private Panel screen = new Panel();
    private Panel arithSymbolArea = new Panel();
    private Panel digitalArea = new Panel();
    private JButton[] digitalButtons = new JButton[10];

    public void init() {
        // Put a screen for output
        screen.add(new TextField(40));
        frame.add(screen, BorderLayout.NORTH);

        // To put the Arith symbols
        arithSymbolArea.setLayout(new GridLayout(6, 4));
        frame.add(arithSymbolArea);

        digitalArea.setLayout(gBagLayout);
        initDigitalArea();
        frame.add(digitalArea, BorderLayout.EAST);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                super.windowClosing(e);
                System.exit(0);
            }
        });

            frame.pack();
            frame.setVisible(true);
        }

    private void initDigitalArea() {

        JButton mc = new JButton("mc");
        JButton mplus = new JButton("m+");
        JButton mminus = new JButton("m-");
        JButton mr = new JButton("mr");

        JButton ac = new JButton("AC");
        JButton pn = new JButton("+/-");
        JButton divide = new JButton("÷");
        JButton times = new JButton("×");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton equal = new JButton("=");
        JButton dot = new JButton(".");
        for (int i = 0; i < 10; i++) {
            digitalButtons[i] = new JButton(String.valueOf(i));
        }

        addComponent(mc, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(mplus, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(mminus, 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(mr, 3, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(ac, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(pn, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(divide, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(times, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(digitalButtons[7], 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[8], 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[9], 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(minus, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(digitalButtons[4], 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[5], 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[6], 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(plus, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(digitalButtons[1], 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[2], 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(digitalButtons[3], 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(equal, 3, 4, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(digitalButtons[0], 0, 5, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(dot, 2, 5, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

    }

    private  void addComponent(JButton button, int gridx, int gridy,
              int gridwidth, int gridheight, int anchor, int fill) {
            GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                anchor, fill, insets, 0, 0);
            gBagConstraints = gbc;
            addButton(button);
          }


    private void addButton(JButton button) {
        gBagLayout.setConstraints(button, gBagConstraints);
        digitalArea.add(button);
    }

    public static void main(String[] args) {
        new MyCalculater().init();
    }


    private void calculate() {

    }



    class DigitalButton extends JButton {
        public DigitalButton() {
            // TODO Auto-generated constructor stub
            this.setBackground(new Color(0, 0, 0));
        }
    }

    class ArithSymbol extends JButton {
        public ArithSymbol() {
            // TODO Auto-generated constructor stub
            this.setBackground(new Color(128, 128, 128));
        }
    }

}