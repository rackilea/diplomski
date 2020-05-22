import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class ImageExample2 extends Applet {

    private Image bi;

    public void init() {

        resize(500, 500);

        System.out.println(getCodeBase()); // file:/D:/Workspace/JavaProject/bin/

        // This the actual code that should be used to read the image in Applet
        bi = getImage(getCodeBase(), "images/222.png");
    }

    public void paint(Graphics g) {
        g.drawImage(bi, 20, 140, this);

    }
}