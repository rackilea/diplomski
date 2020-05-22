import java.awt.FlowLayout;
  import java.awt.event.ActionListener;
  import javafx.event.ActionEvent;
  import javax.swing.ButtonGroup;
  import javax.swing.ImageIcon;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JPanel;
  import javax.swing.JRadioButton;
  import static sun.misc.ClassFileTransformer.add;

  public class DisplayImage extends JFrame {

    private JRadioButton pic1Button, pic2Button;
    private JLabel pic1Label;

    public DisplayImage() {
      super("JRadioButton Image");
      setLayout(new FlowLayout());

      pic1Button = new JRadioButton("pic1");
      pic1Button.addActionListener(new DisplayListener());

      pic2Button = new JRadioButton("pic2");
      pic2Button.addActionListener(new DisplayListener());
      ButtonGroup bg = new ButtonGroup();
      bg.add(pic1Button);
      bg.add(pic2Button);
      JPanel panel = new JPanel();
      panel.add(pic1Button);
      panel.add(pic2Button);
      add(panel);
      pic1Label = new JLabel();
      add(pic1Label);
    }

    private class DisplayListener implements ActionListener {

      public void actionPerformed(ActionEvent e) {
        ImageIcon icon = null;
        if (e.getSource() == pic1Button) {
          icon = new ImageIcon(getClass().getResource("car.jpg"));
        }
        if (e.getSource() == pic2Button) {
          icon = new ImageIcon(getClass().getResource("plane.jpg"));
        }
        pic1Label.setIcon(icon);

      }

    }

    public static void main(String[] args) {
      DisplayImage gui = new DisplayImage();
      gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gui.setSize(300, 300);
      gui.setVisible(true);
    }
  }