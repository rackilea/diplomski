// to enable antialiasing (AA) for Swing components
//
// either:
//    start the JVM with the option -Dawt.useSystemAAFontSettings=on
//    see also: http://docs.oracle.com/javase/6/docs/technotes/guides/2d/flags.html#aaFonts
// or:
//    System.setProperty("awt.useSystemAAFontSettings", "on");
//    - you must call it before the first Swing component is rendered
//    - if AA it's on by default you must set it "off", otherwise you can't
//      toggle it inside the application

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_OFF;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class SwingAntiAliasingDemo {

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "off");
        initGui();
    }

    public static void initGui() {
        JFrame frame = new JFrame();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        Font font = new Font("Serif", Font.TRUETYPE_FONT, 96);
        JPanel jpanel = new JPanel(new BorderLayout());

        JLabel labelAA = new JLabel("Antialiasing ON") {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(KEY_ANTIALIASING,
                        VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
            }
        };
        labelAA.setFont(font);
        labelAA.setForeground(Color.WHITE);

        JLabel labelNoAA = new JLabel("Antialiasing OFF") {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(KEY_ANTIALIASING,
                        VALUE_ANTIALIAS_OFF);
                super.paintComponent(g);
            }
        };
        labelNoAA.setFont(font);
        labelNoAA.setForeground(Color.WHITE);

        jpanel.setBackground(new Color(0, 22, 95));
        jpanel.add(labelAA, BorderLayout.NORTH);
        jpanel.add(labelNoAA, BorderLayout.SOUTH);

        frame.setTitle("stackoverflow question 16304254");
        frame.getContentPane().add(jpanel);
        frame.setLocation(200, 200);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}