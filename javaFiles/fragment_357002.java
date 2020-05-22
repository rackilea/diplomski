package dataGraph;

import javax.swing.*;
import java.awt.*;

import java.awt.Graphics;

public class graphGUI extends JPanel {

    public GraphGUI() {

        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(40, 425, 450, 425);
        g.drawLine(40, 425, 40, 70);
        g.drawString("Graph", 20, 20);
        g.drawLine(50, 50, 50, 50);

        for(int i = 0; i < dataEntryGUI.x.size(); i++){
            g.drawOval(Integer.parseInt(dataEntryGUI.x.get(i)),
                    Integer.parseInt(dataEntryGUI.y.get(i)),5,5);
        }
    }
}