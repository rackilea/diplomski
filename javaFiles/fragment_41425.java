import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends Applet {

Image img;

public void init() {
    setSize(700, 700);

    img = getImage(getDocumentBase(), "dancer1.gif");

}

public void update(Graphics g) {
    g.drawImage(img, 140, 200, this);
}

public void paint(Graphics g) {
    update(g);
}

}