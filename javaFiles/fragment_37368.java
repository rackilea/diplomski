import java.awt.Color;
import javax.swing.*;

public class Container {

    JFrame frame = new JFrame();
    JPanel cont = new JPanel();
    Second second_panel = new Second();

    public Container() {
        cont.setBackground(Color.GREEN);
        cont.add(second_panel.getPanel());
        frame.add(cont);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new Container();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class Second {

    JPanel cont = new JPanel();
    First first_panel = new First();

    public Second() {
        cont.setBackground(Color.RED);
        cont.add(new JLabel("Second"));
        cont.add(first_panel.getPanel());
    }

    public JComponent getPanel() {
        return cont;
    }
}

class First {

    JPanel cont = new JPanel();

    public First() {
        cont.setBackground(Color.YELLOW);
        cont.add(new JLabel("First"));
    }

    public JComponent getPanel() {
        return cont;
    }
}