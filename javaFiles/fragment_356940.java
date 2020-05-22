// to enable antialiasing (AA) for draw operations

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_OFF;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class DrawAntiAliasingDemo extends JFrame {

    private Font font;
    private Color backGroundColor;

    public static void main(String[] args) {
        new DrawAntiAliasingDemo();
    }

    public DrawAntiAliasingDemo() {
        font = new Font("Serif", Font.TRUETYPE_FONT, 96);
        backGroundColor = new Color(0, 22, 95);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setTitle("stackoverflow question 16304254");
        setSize(850, 260);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D d = (Graphics2D) g;
        d.setColor(backGroundColor);
        d.fillRect(0, 0, getWidth(), getHeight());
        d.setFont(font);
        d.setPaint(Color.white);

        d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        d.drawString("Antialiasing ON", 10, 115);

        d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_OFF);
        d.drawString("Antialiasing OFF", 10, 230);
    }
}