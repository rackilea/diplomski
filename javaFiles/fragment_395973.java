import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageCreation extends JFrame
{
    JButton browseBtn=new JButton("Browse");
    JButton removeBtn=new JButton("Remove");
    String filename;
    BufferedImage img;
    JLabel imgLbl;
    private volatile JLabel lastFocused;

    public ImageCreation()
    {
        setSize(500,500);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(browseBtn);
        add(removeBtn);

        browseBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                chooser.addChoosableFileFilter(new
                        FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setCurrentDirectory(new
                        File(System.getProperty("user.home")));
                int option = chooser.showOpenDialog(ImageCreation.this);
                if(option == JFileChooser.APPROVE_OPTION) {
                    filename=chooser.getSelectedFile().toString();

                    try {
                        img = ImageIO.read(new File(filename));
                        imgLbl = new JLabel();
                        imgLbl.setIcon(new ImageIcon(img));
                        imgLbl.setBounds(150,50,img.getWidth(),img.getHeight());
                        add(imgLbl);
                        imgLbl.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getComponent() instanceof JLabel)
                                    lastFocused = (JLabel) e.getComponent();
                            }
                        });

                        imgLbl.repaint();

                    } catch (IOException e) { }

                }
            }
        });

        removeBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lastFocused==null)
                    JOptionPane.showMessageDialog(null,"You Must Select an Label to remove it");
                if (lastFocused != null)
                {
                    Container scollPane = lastFocused;
                    System.out.println(scollPane);
                    Container parent = scollPane.getParent();
                    System.out.println(parent);
                    parent.remove(scollPane);
                }
                repaint();
            }
        });

    }

    public static void main(String args[])
    {
        new ImageCreation();
    }
}