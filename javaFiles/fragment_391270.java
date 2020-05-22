import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Graphics;

public final class PullingAppletExample{
    private JFrame mainWindow = null;   
    private JMenuBar menuContainer = null;
    private JMenu    menu1 = null; 
    private JMenu    menu2 = null;
    private JMenuItem mnuItem1 = null;
    private JMenuItem mnuItem2 = null;
    private JMenuItem mnuItem3 = null;
    private JMenuItem mnuItem4 = null;

    public PullingAppletExample(){

        menu1 = new JMenu("Menu #1");
        menu2 = new JMenu("Menu #2");
        mnuItem1 = new JMenuItem("Item #1");
        mnuItem2 = new JMenuItem("Item #2");
        mnuItem3 = new JMenuItem("Item #3");
        mnuItem4 = new JMenuItem("Item #4");

        menu1.add(mnuItem1);
        menu1.add(mnuItem2);
        menu1.add(mnuItem3);

        menu2.add(mnuItem4);

        menuContainer = new JMenuBar();
        menuContainer.add(menu1);
        menuContainer.add(menu2);

        mainWindow = new JFrame();
        mainWindow.setTitle("Applet Inside JFrame");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setBounds(100,100,500,500);
        mainWindow.setJMenuBar(menuContainer);
        mainWindow.setVisible(true);
        mainWindow.setContentPane(new CustomApplet());

    }
    private class CustomApplet extends JApplet{
        @Override
        public void init(){
            repaint();
        }
        @Override
        public void paint(Graphics g){
            g.drawString("Hello World",100,50);
        }
    }

    public static void main(String[] args) {
        new PullingAppletExample();
    }
}