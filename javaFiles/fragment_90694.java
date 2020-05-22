import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StartWindow {

    JFrame frame;
    private JButton button;
    private JButton button2;
    final String button_start = "img/start.png";
    ImageIcon start = new ImageIcon(button_start);

    public void CreateStartWindow() throws IOException  {
        frame = Window.createwindow();
        Container container = frame.getContentPane();
        JpanelStart panel = new JpanelStart();
        container.add(panel);

        this.button = new JButton(start);
        button.setActionCommand("start");
        button.setHideActionText(true);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        this.button2 = new JButton("Classifica");

        panel.add(button);
        panel.add(button2);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try {
                    new StartWindow().CreateStartWindow();
                } catch (IOException ex) {
                    Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void addActionListener(ActionListener al) {
        this.button.addActionListener(al);
        this.button2.addActionListener(al);
    }

    public void chiudi() {
        frame.dispose();
    }
}

class Window {

    public static JFrame createwindow() {//fare singleton

        JFrame frame = new JFrame("Battaglia navale");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        return frame;

    }

}



class JpanelStart extends JPanel {
    private static final int D_W = 700;
    private static final int D_H = 700;

    private Image img;
    private String path_img = "/images/logo.gif";

    public JpanelStart() throws IOException {

        img = ImageIO.read(StartWindow.class.getResource(path_img));
        loadImage(img);

    }

    private void loadImage(Image img) {
        try {
            MediaTracker track = new MediaTracker(this);
            track.addImage(img, 0);
            track.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, D_W, D_W, this);
    }

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }
}