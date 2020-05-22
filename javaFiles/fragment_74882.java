import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game().gui();
            }
        });
    }

    public void gui() {
        DrawPanel panel = new DrawPanel();
        JFrame frame = new JFrame("Test");
        frame.add(panel, BorderLayout.CENTER);
        frame.add(new MainMenu(), BorderLayout.SOUTH);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}

class MainMenu extends JPanel  {

//  GamePanel panel = new GamePanel();

    public MainMenu() {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton b1 = new JButton("Start");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 200;

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(b1, c);
    }
}

class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 200, 200);
    }
}