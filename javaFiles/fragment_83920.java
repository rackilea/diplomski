import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Example {

    private static int[][] pos = {{10, 10, 72, 77}, {65, 0, 122, 69}};

    public static MyButton[] buttons;

    private static URL[] src = new URL[2]; 

    private static MapPanel pane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                try{
                    src[0] = new URL("https://dl.dropbox.com/s/dxbao8q0xeuzhgz/button1.png");
                    src[1] = new URL("https://dl.dropbox.com/s/v16kyha0ojx1gza/button2.png");
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(0);
                }

                pane = new MapPanel();
                pane.setLayout(null);

                buttons = new MyButton[2];

                for(int i = 0 ; i < buttons.length ; i++){
                    final int j = i;
                    try{
                        buttons[j] = new MyButton((ImageIO.read(src[j])), j, pos[j][0], pos [j][1]);
                    } catch (Exception e){
                        e.printStackTrace();
                        System.exit(0);
                    }
                    buttons[j].addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent me){
                            Point p = new Point(me.getX() + buttons[j].getX(), me.getY() + buttons[j].getY());
                            pane.check(p);
                        }
                    });
                    buttons[j].setBounds(pos[j][0], pos[j][1], pos[j][2], pos[j][3]);
                    pane.add(buttons[j]);
                }

                frame.setContentPane(pane);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(210, 130);
                frame.setVisible(true);
            }
        });
    }
}

class MapPanel extends JLabel{

    public MapPanel(){
        super();
        this.setOpaque(true);
    }

    public void check(Point p){
    for(int i = 0 ; i < Example.buttons.length ; i++){
    if(Example.buttons[i].contains(p)){
            Example.buttons[i].clickDetected();
            break;
        }
        }
    }
}

class MyButton extends JButton {

    private BufferedImage icon;
    private int x, y, index;
    private Area area;

    MyButton(BufferedImage bi, int index, int x, int y) {
        this.icon = ((BufferedImage) bi);
        this.x = x;
        this.y = y;
        this.index = index;
        setContentAreaFilled(false);
        createArea();
    }

    @Override
    public Dimension getPreferredSize() {
        if(icon != null){
            return new Dimension(icon.getWidth(), icon.getHeight());
        } else {
            return super.getPreferredSize();
            }
    }

    public BufferedImage getIconImage() {
        return icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon, 0, 0, null);
        g.dispose();
    }

    private void createArea(){      
        GeneralPath gp = new GeneralPath();
        boolean cont = false;

        for(int xx = 0 ; xx < icon.getWidth() ; xx++){
            for(int yy = 0 ; yy < icon.getHeight() ; yy++){
                if(getAlpha(xx, yy) != 0){
                    if(cont){
                        gp.lineTo(xx, yy);
                        gp.lineTo(xx, yy+1);
                        gp.lineTo(xx+1, yy+1);
                        gp.lineTo(xx+1, yy);
                        gp.lineTo(xx, yy);
                    } else{
                        gp.moveTo(xx, yy);
                    }
                    cont = true;
                } else {
                    cont = false;
                }
            }
            cont = false;
        }

        gp.closePath();

        area = new Area(gp);        
    }

    @Override
    public boolean contains(Point p){
        if(area.contains(new Point((int)(p.getX() - this.x), (int) (p.getY() - this.y)))){
            return true;
        }
        return false;
    }

    private int getAlpha(int posx, int posy){
        return(icon.getRGB(posx, posy) >> 24) & 0x000000FF;
    }

    public void clickDetected(){
        JOptionPane.showMessageDialog(null, "You clicked button " + Integer.toString(this.index + 1) + ".");
    }
}