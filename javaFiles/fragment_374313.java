import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Example {

    public Example() {
        ColorButton button = new ColorButton("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.changeBackground();
            }
        });
        button.doClick();

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}

class ColorButton extends JButton {

    private Color rec1Color;
    private Color rec2Color;
    private Color rec3Color;
    private Color rec4Color;
    private Random random = new Random();

    public ColorButton(String text) {
        setText(text);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getRec1Color());
        g.fillRect(0, 0, getWidth() / 2, getHeight() / 2);
        g.setColor(getRec2Color());
        g.fillRect(getWidth() / 2, 0, getWidth() / 2, getHeight() / 2);
        g.setColor(getRec3Color());
        g.fillRect(0, getHeight() / 2, getWidth() / 2, getHeight() / 2);
        g.setColor(getRec4Color());
        g.fillRect(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2);
        g.setColor(getForeground());
        g.drawString(getText(), (getWidth() - g.getFontMetrics().stringWidth(getText())) / 2,
                (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent());
    }

    public void changeBackground() {
        setRec1Color(createRandomColor());
        setRec2Color(createRandomColor());
        setRec3Color(createRandomColor());
        setRec4Color(createRandomColor());
    }

    private Color createRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public Color getRec1Color() {
        return rec1Color;
    }

    public void setRec1Color(Color rec1Color) {
        this.rec1Color = rec1Color;
    }

    public Color getRec2Color() {
        return rec2Color;
    }

    public void setRec2Color(Color rec2Color) {
        this.rec2Color = rec2Color;
    }

    public Color getRec3Color() {
        return rec3Color;
    }

    public void setRec3Color(Color rec3Color) {
        this.rec3Color = rec3Color;
    }

    public Color getRec4Color() {
        return rec4Color;
    }

    public void setRec4Color(Color rec4Color) {
        this.rec4Color = rec4Color;
    }

}