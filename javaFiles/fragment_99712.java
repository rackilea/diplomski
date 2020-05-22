package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;

public class DialogListener {

    public static void main(String[] args) throws AWTException {
        final JDialog dialog = new JDialog();
        dialog.setSize(300, 400);
        dialog.setVisible(true);

        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        final Rectangle screen = new Rectangle(scrnSize.width, 2*scrnSize.height - winSize.height);

        dialog.addComponentListener(new ComponentAdapter() {            
            @Override
            public void componentMoved(ComponentEvent e) {
                if (!screen.contains(dialog.getBounds()))
                    dialog.setLocation(300, 400);
            }
        }); 
    }
}