import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class Frame extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Image MeSmaller1;
    private Image MeSmaller2;
    protected Timer timer;
    private float alpha;

    JPanel pnlButton = new JPanel();
    static JButton btnStartBlend = new JButton("Start Blend");
    static JButton btnStopBlend = new JButton("Stop Blend");
    static JButton saveImage = new JButton("Save Image To File");

    /*BtnStartBlendListener BtnStart = new BtnStartBlendListener();
     BtnStopBlendListener BtnStop = new BtnStopBlendListener();
     SaveImageListener SaveImg = new SaveImageListener();*/
    public Frame() {

        loadImages();
        initTimer();
        timer.start();
        //      timer.stop();

        pnlButton.add(btnStartBlend);
        this.add(pnlButton);
        pnlButton.add(btnStopBlend);
        this.add(pnlButton);
        pnlButton.add(saveImage);
        this.add(pnlButton);

        addListeners();
    }

    public void addListeners() {
        //start button actionlistener
        btnStartBlend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTimer();
                timer.start();

                System.out.println("Timer started");
            }
        });

        //stop button actionlistener
        btnStopBlend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // initTimer();
                timer.stop();

                System.out.println("Timer stopped");
            }
        });

        //Save button actionlistener
        saveImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Call to method to save image

                System.out.println("Save image clicked");
            }
        });
    }

    private void loadImages() {
        MeSmaller1 = new ImageIcon("MeSmaller1.jpg").getImage();
        MeSmaller2 = new ImageIcon("MeSmaller2.jpg").getImage();
    }

    public final void initTimer() {

        timer = new Timer(1000, this);
        timer.start();
        timer.stop();
        alpha = 1f;
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2Dim = (Graphics2D) g;
        // below sets the size of picture
        BufferedImage buffImage = new BufferedImage(400, 600,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D gBuffI = buffImage.createGraphics();
        AlphaComposite aComp = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        // decides where images are drawn in JFrame
        gBuffI.drawImage(MeSmaller1, 28, 55, null);
        gBuffI.setComposite(aComp);
        gBuffI.drawImage(MeSmaller2, 30, 48, null);
        g2Dim.drawImage(buffImage, 10, 10, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alpha -= 0.1;
        if (alpha <= 0) {
            alpha = 0;
            timer.stop();
            System.out.println("Morph Finished please restart.");
        }
        repaint();
    }
}

//---------------------------------------------------------------------------------------------------------

public class PictureMorph extends JFrame {

    private static final long serialVersionUID = 1L;

    public PictureMorph() {
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Image Morph");
        setTitle("Facial Image Manipulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Frame());
        // below set Frame Size around image
        setSize(380, 470);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PictureMorph picMorph = new PictureMorph();
                picMorph.setVisible(true);
            }
        });
    }
}