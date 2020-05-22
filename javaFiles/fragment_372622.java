import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new MyFrame();
      }
    });
  }

  private final Container contentContainer;

  public MyFrame() {

    setTitle("MyFrame");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setJMenuBar(createMenu());
    contentContainer = getContentPane();
    contentContainer.add(new MyPanel("Test oO"));

    setVisible(true);
  }

  public JMenuBar createMenu() {

    JMenuBar menuBar = new JMenuBar();

    JMenu menu = new JMenu("Menu");

    JMenuItem menuItem = new JMenuItem("Test");
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        MyPanel dynamicPanel = new MyPanel("Test");
        contentContainer.removeAll();
        contentContainer.add(dynamicPanel);
        contentContainer.revalidate();
        contentContainer.repaint();
      }
    });

    menu.add(menuItem);

    JMenuItem menuItem1 = new JMenuItem("Test 1");
    menuItem1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        contentContainer.removeAll();
        contentContainer.add(new MyPanel("Test 1"));
        contentContainer.revalidate();
        contentContainer.repaint();
      }
    });
    menu.add(menuItem1);

    menuBar.add(menu);
    return menuBar;
  }

}

class MyPanel extends JPanel {

  public MyPanel(String config) {
    JButton testButton = new JButton(config);
    add(testButton);
    setVisible(true);
    revalidate();
    repaint();
  }
}