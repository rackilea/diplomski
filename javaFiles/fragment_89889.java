import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.*;

public class Clock2d extends JPanel {

    TimeZone clockTimeZone = TimeZone.getDefault();
    GregorianCalendar cal = 
            (GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
    ActionListener repaintListener = (ActionEvent e) -> {
        cal = (GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
        repaint();
    };
    Timer clockTimer = new Timer(100, repaintListener);

    public Clock2d() {
        clockTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(40, 40, 220, 220);
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 200, 200);

        double second = cal.get(Calendar.SECOND);
        double minute = cal.get(Calendar.MINUTE);
        double hours = cal.get(Calendar.HOUR);

        for (int i = 0; i < 60; i++) {
            int length = 90;
            double rad = (i * 6) * (Math.PI) / 180;
            if (i % 5 == 0) {
                length = 82;
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GRAY);
            }
            int x = 150 + (int) (95 * Math.cos(rad - (Math.PI / 2)));
            int y = 150 + (int) (95 * Math.sin(rad - (Math.PI / 2)));
            int x1 = 150 + (int) (length * Math.cos(rad - (Math.PI / 2)));
            int y1 = 150 + (int) (length * Math.sin(rad - (Math.PI / 2)));
            g.drawLine(x, y, x1, y1);
        }

        drawHands(g, second, minute, hours);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        g.setColor(Color.BLUE);
        g.setFont(new Font("Tahoma", Font.BOLD, 16));
        g.drawString(sdf.format(cal.getTime()), 120, 20);
        g.setFont(new Font("Arial", Font.BOLD, 10));

    }

    public void drawHands(Graphics g, double second, double minute, double hours) {
        double rSecond = (second * 6) * (Math.PI) / 180;
        double rMinute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
        double rHours = ((hours + (minute / 60)) * 30) * (Math.PI) / 180;
        g.setColor(Color.RED);
        g.drawLine(150, 150, 150 + (int) (100 * Math.cos(rSecond - (Math.PI / 2))), 150 + (int) (100 * Math.sin(rSecond - (Math.PI / 2))));
        g.setColor(Color.BLACK);
        g.drawLine(150, 150, 150 + (int) (70 * Math.cos(rMinute - (Math.PI / 2))), 150 + (int) (70 * Math.sin((rMinute - (Math.PI / 2)))));
        g.drawLine(150, 150, 150 + (int) (50 * Math.cos(rHours - (Math.PI / 2))), 150 + (int) (50 * Math.sin(rHours - (Math.PI / 2))));
    }

    public static void main(String[] args) {
        // Swing / AWT GUIs should be created & changed on the EDT ..
        Runnable r = () -> {
            JFrame frame = new JFrame("Clock 2D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(330, 330));
            Clock2d clock2d = new Clock2d();
            clock2d.setPreferredSize(new Dimension(320, 320));
            frame.setLayout(new BorderLayout());
            frame.getContentPane().add(clock2d, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        };
        // .. this is how we ensure that Runnable is on the EDT.
        SwingUtilities.invokeLater(r);
    }
}