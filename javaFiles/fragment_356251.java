import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Run2
{

    public static void main (String [] args) throws IOException
    {
        JFrame frame = new JFrame();
        frame.add( new WorldCreation2());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


class WorldCreation2 extends JComponent
{

    private int rows = 15, cols = 10;
    private URL[] urls = { //use embedded resources for posting question
            getUrl("http://static.coach.com/aapz_prd/on/demandware.static/-/Library-Sites-globalLibrary/default/dw1777ce46/201708/canada-wwcm/close_grey.png"),
            getUrl("https://s7d2.scene7.com/is/image/JCPenney/DP0423201517014421S.jpg?wid=20&hei=20&op_usm=.4,.8,0,0&resmode=sharp2"),
            getUrl("https://i2.wp.com/www.todaytells.com/wp-content/uploads/2018/07/new-and-ongoing-cinema-releases-uk-ire-from-thu-jul-12.jpg?fit=20%2C20&ssl=1")
    };

    public WorldCreation2() {

        setLayout(new GridLayout(rows, cols));
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(row < 5)
                {
                    add(getTile(urls[0]));
                }else if (row < 10) {
                    add(getTile(urls[1]));
                }else {
                    add(getTile(urls[2]));
                }
            }
        }
    }

    private JLabel getTile(URL url){

        return new JLabel(new ImageIcon(url));
    }

    private URL getUrl(String path) {

        URL url = null;
        try {
            url =   new URL(path);
        } catch (MalformedURLException ex) {    ex.printStackTrace();   }

        return url;
    }
}