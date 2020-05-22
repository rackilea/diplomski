import java.awt.Component;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Main {

   public static void main(String[] args) throws IOException {

    JFrame frame = new JFrame("FullScreen Demo");
    frame.setUndecorated(true);

    frame.add(new Component() {
        BufferedImage bg = ImageIO.read(new URL("http://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/Neige_dans_le_djebel_Ch%C3%A9lia.JPG/1920px-Neige_dans_le_djebel_Ch%C3%A9lia.JPG"));
        BufferedImage fg = ImageIO.read(new URL("http://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/W1769-Vallet_BMX_N_82131.JPG/1920px-W1769-Vallet_BMX_N_82131.JPG"));
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(fg, 50, 50, getWidth()/10, getHeight()/10, this);

        }
    });

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gs = ge.getDefaultScreenDevice();
    gs.setFullScreenWindow(frame);
    frame.validate();
}
}