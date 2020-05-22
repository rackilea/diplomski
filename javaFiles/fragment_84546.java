import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class NewClass extends JFrame {

final int grid = 20;
final int pnlCnt = grid * grid;
final JFrame frame = new JFrame("WELCOME TO THE MATRIX");
final JPanel[] panels = new JPanel[pnlCnt];
Timer t;

public NewClass() {
    for (int i = 0; i < panels.length; i++) {
        final String[] labels = new String[]{"0", "1"};
        final Random rand = new Random();
        int index = rand.nextInt(labels.length);
        String randomTitle = labels[index];
        final JLabel label = new JLabel(randomTitle, JLabel.CENTER);
        Timer lblt = new Timer(00, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               label.setText(labels[rand.nextInt(labels.length)]);
            }
        });
        lblt.setRepeats(true);
        lblt.start();
        label.setForeground(Color.green);
        label.setVerticalAlignment(JLabel.CENTER);
        panels[i] = new JPanel();
        panels[i].setBackground(Color.BLACK);
        panels[i].add(label);
        frame.getContentPane().add(panels[i]);
    }
    frame.setLayout(new GridLayout(grid, grid));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    frame.setVisible(true);

    //I know this won't do what I want, but I think this is where I need 
    //to add code to randomize the panels or labels
    ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < panels.length; i++) {
                Color mix = new Color(255, 255, 255);
                Random random = new Random();
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);

                if (mix != null) {
                    r = (r + mix.getRed()) / 2;
                    g = (g + mix.getGreen()) / 2;
                    b = (b + mix.getBlue()) / 2;
                }
                Color color = new Color(r, g, b);
                panels[i].setBackground(color);
            }
        }
    };

    t = new Timer(00, action);
    t.setRepeats(true);
    t.start();
}

public static void main(String args[]) {
    NewClass q = new NewClass();
    }
}