import com.googlecode.javacv.CanvasFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class Test {
    BufferedImage bi;
    CanvasFrame cf;
    public Test() throws IOException{
        bi = ImageIO.read(getClass().getResource("/resources/colorspec_.jpg"));
        cf = new CanvasFrame("Canvas With Button");
        cf.setLayout(new MigLayout("insets 0, gap 10", "grow", "grow"));
        cf.add(new JButton("My Button"), "w 100:100:100, h 40:40:40");
    }

    public void showWindow(){
        cf.showImage(bi);
        cf.pack();
    }

    public static void main(String[] args) throws IOException {
        Test t = new Test();
        t.showWindow();
    }
}