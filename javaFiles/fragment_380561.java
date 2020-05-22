import javax.swing.*;

public class Menu {
public static void main (String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(500, 300);

    JMenuBar menuBar = new JMenuBar();
    JMenu menu1 = new JMenu("menu1");
    JMenu menu2 = new JMenu("menu2");
    JMenu menu3 = new JMenu("menu3");
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);

    frame.setJMenuBar(menuBar);
    frame.setUndecorated(true);     
    frame.setVisible(true);
}
}