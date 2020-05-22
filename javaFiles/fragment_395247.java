import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestLink {

    public static void main(String[] args) {
        JLabel label = new JLabel("stackoverflow");
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                if (Desktop.isDesktopSupported()) {
                    try {
                      Desktop.getDesktop().browse(new URI("http://stackoverflow.com"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                  } else { 
                      //TODO 
                  }
            }  
        }); 
        JOptionPane.showMessageDialog(null, label);
    }
}