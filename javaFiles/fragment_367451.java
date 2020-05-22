import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

public class CustomPopupMenuBorder
{
    public static void main(String[] args)
    {
        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(Color.black, 1));      
        JDialog myJDialog = new JDialog();
        myJDialog.setSize(450,300);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("It's a me");
        JMenuItem item = new JMenuItem("JMenuItem 1");
        JMenuItem item2 = new JMenuItem("JMenuItem 2");
        menu.add(item);
        JSeparator sep = new JSeparator();    
        menu.add(sep);
        menu.add(item2);
        bar.add(menu);
        myJDialog.setJMenuBar(bar);
        myJDialog.setVisible(true);
    }
}