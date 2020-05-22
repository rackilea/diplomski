import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class MenuExample {

    private void setupMenuKey(final JFrame frame) {
        Action menuAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JRootPane rootPane = frame.getRootPane();
                JMenuBar jMenuBar = rootPane.getJMenuBar();
                JMenu menu = jMenuBar.getMenu(0);
                menu.doClick();
            }
        };

        JRootPane rootPane = frame.getRootPane();
        ActionMap actionMap = rootPane.getActionMap();

        final String MENU_ACTION_KEY = "expand_that_first_menu_please";
        actionMap.put(MENU_ACTION_KEY, menuAction);
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ALT, 0, true), MENU_ACTION_KEY);
    }


    private JFrame build() {
        JFrame frame = new JFrame("Hello");
        frame.setSize(300, 300);

        JMenuBar bar = new JMenuBar();

        List<String> letters = Arrays.asList("A", "B", "C");
        for (int i = 0; i < 3; i++) {
            JMenu menu = new JMenu("Menu " + i);
            for (String string : letters) {
                menu.add(new JMenuItem(String.format("Menu %s - %s", i, string)));
            }
            bar.add(menu);
        }
        frame.setJMenuBar(bar);

        JButton b = new JButton("click");
        JPanel p = new JPanel();
        p.add(b);
        frame.add(p);
        setupMenuKey(frame);

        return frame;
    }

    public static void main(String[] args) {
        MenuExample menuExample = new MenuExample();
        JFrame frame = menuExample.build();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}