import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImgViewTester extends JFrame implements ActionListener
{
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openItem = new JMenuItem("Open Image...");       

    JPanel imagePanel;

    JFileChooser fc = new JFileChooser();

    File imgFile;
    String imgFileName;
    String imgTitle;
    protected Image img = null;
    Image newImg = null;
    Image imgResized = null;
    BufferedImage buffImg = null;

    boolean doGetImg = false;

    public ImgViewTester()
    {
        initialize();
    }

    public void initialize()
    {
        this.setTitle("Image Editor");
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(openItem);
        openItem.addActionListener(this);                 

        ImagePanel theImagePanel = new ImagePanel();        
        this.add(theImagePanel, BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args){
        new ImgViewTester();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(openItem))
        {
            doGetImg = true;

            JFileChooser imgFileChooser = new JFileChooser();
            FileNameExtensionFilter imgFilter =
                    new FileNameExtensionFilter("GIF, PNG, JPEG or JPG files",
                            "gif", "png", "jpg", "jpeg");

            imgFileChooser.setFileFilter(imgFilter);
            int returnVal = imgFileChooser.showOpenDialog(this);
            imgFile = imgFileChooser.getSelectedFile();

            //variables for getting name of image
            imgFileName = imgFile.getName();
            imgTitle = imgFileName.substring(imgFileName.lastIndexOf("/") + 1);

            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    img = ImageIO.read(imgFile);
                    img = img.getScaledInstance(500, -1, Image.SCALE_DEFAULT);
                }
                catch(IOException ioe)
                {
                    System.out.println("Oops! Image I/O exception occurred!");
                    ioe.printStackTrace();
                }

                buffImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                  repaint();
            }
            else if(returnVal == JFileChooser.CANCEL_OPTION)
            {
                //handle cancel operation
            }

        }
     }

    class ImagePanel extends JPanel
    {
        public ImagePanel()
        {
            this.setPreferredSize(new Dimension(500, 500));
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            Graphics2D _g2d;
            Graphics _gb;

            if(doGetImg == true)
            {
                System.out.println("inside ORIGINAL IMAGE paint method");

                super.paintComponents(g);
                _g2d = (Graphics2D) g;
                _gb = buffImg.getGraphics();

                _gb.drawImage(img, 0, 0, null);
                _gb.dispose();
                _g2d.drawImage(buffImg, null, 0, 0);
                _g2d.dispose();                                              
            }
        }
    }

}//end of class