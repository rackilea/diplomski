import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuffImgTest {

    private BufferedImage scaledImg, originalScaledImg;
    private JFrame frame;

    private Stack<BufferedImage> imageStack = new Stack<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuffImgTest window = new BuffImgTest();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuffImgTest() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());

        final JLabel imgLabel = new JLabel("");
        imgLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {

                // Add current image to the image stack
                imageStack.add(copyImage(scaledImg));

                // Change the image
                Graphics graphics = scaledImg.getGraphics();
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial", Font.BOLD, 32));
                graphics.drawString("TEST", arg0.getX(), arg0.getY());

                // Update label
                Image img = Toolkit.getDefaultToolkit().createImage(
                        scaledImg.getSource());
                imgLabel.setIcon(new ImageIcon(img));
            }
        });

        imgLabel.setSize(500, 500);
        imgLabel.setPreferredSize(new Dimension(500, 500));

        try {
            BufferedImage buffImg = ImageIO.read(new File("test.jpg"));

            scaledImg = getScaledImage(buffImg, imgLabel.getWidth(),
                    imgLabel.getHeight());

            // Clone it first
            originalScaledImg = copyImage(scaledImg);

            Image img = Toolkit.getDefaultToolkit().createImage(
                    scaledImg.getSource());
            imgLabel.setIcon(new ImageIcon(img));

        } catch (Exception e) {
            System.out.println(e);
        }

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, 10, 10, 10);
        panel.add(imgLabel, c);

        JButton restartBtn = new JButton("Restart Step");
        restartBtn.setFont(new Font("Arial", Font.ITALIC, 20));
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                // Clear the image stack
                imageStack.clear();

                // Reset the image
                scaledImg = copyImage(originalScaledImg);

                Image img = Toolkit.getDefaultToolkit().createImage(
                        scaledImg.getSource());
                imgLabel.setIcon(new ImageIcon(img));
            }
        });

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 5, 10);
        panel.add(restartBtn, c);

        JButton undoBtn = new JButton("Undo Last");
        undoBtn.setFont(new Font("Arial", Font.ITALIC, 20));
        undoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if(imageStack.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Cannot undo anymore!");
                    return;
                }           

                // Get the previous image
                scaledImg = copyImage(imageStack.pop());

                Image img = Toolkit.getDefaultToolkit().createImage(
                        scaledImg.getSource());
                imgLabel.setIcon(new ImageIcon(img));
            }
        });

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 10, 20, 10);
        panel.add(undoBtn, c);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(800, 800);
    }

    /** For copying image */
    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(
                source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public static BufferedImage getScaledImage(BufferedImage image, int width,
            int height) throws IOException {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(
                scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(
                scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        return bilinearScaleOp.filter(image, new BufferedImage(width, height,
                image.getType()));
    }
}