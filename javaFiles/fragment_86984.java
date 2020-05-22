package paranoid;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Trip2 extends JPanel {

private static final long serialVersionUID = 1L;

private TripModel model;

public void paint(Graphics g){

    g.setColor(Color.BLACK);
    g.fillRect(model.getXMin(), model.getYMin(), model.getXMax(), model.getYMax());

    for (int j = 0; j < 280; j++) {
        for (int i = 0; i < 500; i++) {
            if (model.getScreen()[i][j] == 0) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.GREEN);
            }
            g.drawLine(i, j, i, j); //plots pixel
        }
    }
}

public void setModel(TripModel model) {
    this.model = model;
}

}//en