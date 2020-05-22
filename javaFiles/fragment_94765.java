import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageShow {

  /** Inner class: JPanel that displays images. **/
  static class JImagePanel extends JPanel {

    protected final LinkedList<BufferedImage> images;
    protected BufferedImage currentImage;
    protected int currentIndex;

    public JImagePanel(final LinkedList<BufferedImage> images) {
      super(true);
      this.setFocusable(false);
      this.images = images;
      this.setIndex(0);
    }

    /** Has to be private to not cause issues when used in the constructor. **/
    private void setIndex(final int index) {
      if (index >= this.images.size()) {
        this.currentIndex = 0;
      } else if (index < 0) {
        this.currentIndex = this.images.size() - 1;
      } else {
        this.currentIndex = index;
      }

      this.currentImage = this.images.get(this.currentIndex);
      this.setPreferredSize(new Dimension(this.currentImage.getWidth(), this.currentImage.getHeight()));
      this.repaint();
    }

    public void shiftIndex(final int amount) {
      this.setIndex(this.currentIndex + amount);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(this.currentImage, 0, 0, null);
    }
  }

  public static void main(final String[] args) {
    final LinkedList<BufferedImage> images = loadImages(args);
    if (images.size() > 0) {
      final JFrame window = new JFrame("Image Show");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      final JImagePanel imagePanel = new JImagePanel(images);
      window.add(imagePanel);

      window.addKeyListener(new KeyAdapter() {
        private void shiftIndex(final int amount) {
          imagePanel.shiftIndex(amount);
          window.pack();
          window.setLocationRelativeTo(null);
        }

        @Override
        public void keyReleased(KeyEvent e) {
          switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
              window.dispose();
              e.consume();
              break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4:
              shiftIndex(-1);
              e.consume();
              break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6:
              shiftIndex(+1);
              e.consume();
              break;
          }
        }
      });

      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);
    } else {
      System.err.println("No image could be loaded.\nPlease provide a list of image files as parameters.");
    }
  }

  private static LinkedList<BufferedImage> loadImages(final String[] filenames) {
    final LinkedList<BufferedImage> result = new LinkedList<>();
    for (String filename : filenames) {
      try {
        final File file = new File(filename);
        final BufferedImage image = ImageIO.read(file);
        if (image == null) {
          throw new IOException("Unknown image format");
        }
        result.add(image);
      } catch (IOException e) {
        System.err.println("Unable to load image \"" + filename + "\": " + e.getMessage());
      }
    }
    return result;
  }
}