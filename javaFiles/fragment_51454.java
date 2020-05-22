import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FadingIcon {

  public static void main(String[] args) {
    new FadingIcon();
  }

  public FadingIcon() {
    startUI();
  }

  public void startUI() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
          ex.printStackTrace();
        }

        BufferedImage img = null;
        try {
          img = ImageIO.read(new File("C:\\Users\\swhitehead\\Documents\\My Dropbox\\Ponies\\SmallPony.png"));
        } catch (IOException ex) {
          ex.printStackTrace();
        }

        JFrame frame = new JFrame("Testing");
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FadingLabel(new ImageIcon(img)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public class FadingLabel extends JLabel {

    private boolean mouseIn = false;
    private MouseHandler mouseHandler;

    public FadingLabel(Icon icon) {
      super(icon);
      setBackground(Color.RED);
      super.setOpaque(false)(
    }

    @Override
    public void setOpaque(boolean opaque) {
    }

    @Override
    public final boolean isOpaque() {
        return false;
    }

    protected MouseHandler getMouseHandler() {
      if (mouseHandler == null) {
        mouseHandler = new MouseHandler();
      }
      return mouseHandler;
    }

    @Override
    public void addNotify() {
      super.addNotify();
      addMouseListener(getMouseHandler());
    }

    @Override
    public void removeNotify() {
      removeMouseListener(getMouseHandler());
      super.removeNotify();
    }

    @Override
    protected void paintComponent(Graphics g) {
      if (mouseIn) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
      }
      getUI().paint(g, this);
    }

    public class MouseHandler extends MouseAdapter {

      @Override
      public void mouseEntered(MouseEvent e) {
        mouseIn = true;
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        mouseIn = false;
        repaint();
      }

    }

  }

}