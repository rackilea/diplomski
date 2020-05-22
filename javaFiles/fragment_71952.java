import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import org.jdesktop.jxlayer.JXLayer;
import org.pbjar.jxlayer.demo.TransformUtils;
import org.pbjar.jxlayer.plaf.ext.transform.DefaultTransformModel;

public class MenuExample {

    public static void main(String[] args) {
        new MenuExample();
    }

    public MenuExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JMenu menu = new JMenu("Test");

                JButton build = new JButton("Build");
                build.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        makeItSo(menu);
                    }
                });
                JButton remove = new JButton("Remove");
                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = menu.getMenuComponentCount();
                        Component last = menu.getMenuComponent(count - 1);
                        menu.removeAll();
                        menu.add(last);
                    }
                });

                makeItSo(menu);

                JPanel buttons = new JPanel();
                buttons.add(build);
                buttons.add(remove);

                JMenuBar mb = new JMenuBar();
                mb.add(menu);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setJMenuBar(mb);
                frame.add(buttons, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected void makeItSo(JMenu menu) {
        for (int index = 0; index < (Math.random() * 20); index++) {
            menu.add("MenuItem " + index);
        }
    }
}