import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class TestKeySpeed {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JTextArea area = new JTextArea(20, 40);
                area.setEditable(false);

                JButton button = new JButton("Just something that has focus");
                button.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_1) {
                            area.append("1");
                        }
                    }
                });

                AbstractAction action = new AbstractAction("Add") {
                    {
                        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('2'));
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        area.append("2");
                    }
                };
                button.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                        KeyStroke.getKeyStroke('3'), "add3");
                button.getActionMap().put("add3", action);

                JMenu menu = new JMenu("File");
                menu.add(action);
                JMenuBar bar = new JMenuBar();
                bar.add(menu);
                JFrame frame = new JFrame("Test");
                frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                        KeyStroke.getKeyStroke('4'), "add4");
                frame.getRootPane().getActionMap().put("add4", action);

                frame.setJMenuBar(bar);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new JScrollPane(area));
                frame.getContentPane().add(button, BorderLayout.PAGE_END);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                button.requestFocusInWindow();
            }
        });
    }
}