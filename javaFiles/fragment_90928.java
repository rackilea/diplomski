import java.awt.*;
import javax.swing.*;

public class FrameLayoutTest {

    private static JFrame f;
    private static Canvas c;

    public static void main(String [] args) {
        init();
    }

    private static void init() {
        //Display.createDrawFrame(width, height);
        createDrawFrame(400, 400);
        //Display.createMenuFrame(width, height);
        createHUD();
        //this.f = Display.getDrawFrame();
        //getDrawFrame();
        //this.c = Display.getCanvas();
        //this.f = createHUD(this.f, this);
        //MapAssets.init();
    }

    public static void createDrawFrame(int width, int height) {
        f = new JFrame();
        c = new Canvas();
        c.setBackground(Color.blue);
        c.setPreferredSize(new Dimension(width, height));
        c.setFocusable(false);
        f.add(c, BorderLayout.CENTER); //f.add(c);
        f.pack();
        f.setVisible(true); // getDrawFrame()
        f.setSize(width, height);
        f.setLocationRelativeTo(null);
    }

    public static void createHUD() {
        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        p.setSize(100, 100);
        p.setLocation(300, 0);
        Button b0 = new Button("Settings");
        Button b1 = new Button("Exit");
        //MenuListeners mListeners = new MenuListeners(game);
        //b0.addActionListener(mListeners);
        //b1.addActionListener(mListeners);
        p.add(b0);
        p.add(b1);
        f.add(p, BorderLayout.NORTH); //f.add(p);
    }
}