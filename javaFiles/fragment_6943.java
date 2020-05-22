import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

class Gui {
    //Importiert Auflösung des Bildschirms
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Setzt Variablen für die Auflösung
    public int aufloesungBreite = screenSize.width;
    public int aufloesungHoehe = screenSize.height;

    //Setzt die Berechnung des JFrame hauptfenster Location
    private int breite = aufloesungBreite/2 - 640;
    private int hoehe = aufloesungHoehe/2 - 400;


    public Gui() {
        JFrame hauptfenster = new JFrame("Verwaltungssoftware fuer die Jobsuche");
        hauptfenster.setDefaultCloseOperation(hauptfenster.EXIT_ON_CLOSE);
        hauptfenster.setResizable(false);
        hauptfenster.setLocation(breite, hoehe);
        hauptfenster.setSize(1280,800);
        hauptfenster.setLayout(new BorderLayout(5,5));

        //Addet hauptpanel zum JFrame
        ImagePanel hauptpanel = new ImagePanel();
        hauptfenster.add(hauptpanel);   
        hauptpanel.setVisible(true);
        hauptfenster.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class ImagePanel extends JPanel {
    //Variablen
    Image icon1;

    //Konstruktor
    public ImagePanel() {
        try  {
            URL url = new URL("http://i.stack.imgur.com/7bI1Y.jpg");
            icon1  = ImageIO.read(url);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        setLayout(new BorderLayout (5,5));
        JLabel myLabel=new JLabel(new ImageIcon(icon1));
        add(myLabel);
    }

    // very important!
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(icon1.getWidth(this), icon1.getHeight(this));
    }
}