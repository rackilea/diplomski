import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ContextMenu implements ActionListener, MenuListener, MenuKeyListener {

    private JTextArea textArea = new JTextArea();

    public ContextMenu() {
        final JPopupMenu contextMenu = new JPopupMenu("Edit");
        JMenu menu = new JMenu("Sub Menu");
        menu.add(makeMenuItem("Sub Menu Save"));
        menu.add(makeMenuItem("Sub Menu Save As"));
        menu.add(makeMenuItem("Sub Menu Close"));
        menu.addMenuListener(this);
        JMenu menu1 = new JMenu("Sub Menu");
        menu1.add(makeMenuItem("Deepest Sub Menu Save"));
        menu1.add(makeMenuItem("Deepest Sub Menu Save As"));
        menu1.add(makeMenuItem("Deepest Sub Menu Close"));
        menu.add(menu1);
        menu1.addMenuListener(this);
        contextMenu.add(menu);
        contextMenu.add(makeMenuItem("Plain Save"));
        contextMenu.add(makeMenuItem("Plain Save As"));
        contextMenu.add(makeMenuItem("Plain Close"));
        contextMenu.addMenuKeyListener(this);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        panel.setComponentPopupMenu(contextMenu);
        textArea.setInheritsPopupMenu(true);
        panel.add(BorderLayout.CENTER, textArea);
        JTextField textField = new JTextField();
        textField.setInheritsPopupMenu(true);
        panel.add(BorderLayout.SOUTH, textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(e.getActionCommand() + "\n");
    }

    private JMenuItem makeMenuItem(String label) {
        JMenuItem item = new JMenuItem(label);
        item.addActionListener(this);
        return item;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ContextMenu contextMenu = new ContextMenu();
            }
        });
    }

    public void menuSelected(MenuEvent e) {
        textArea.append("menuSelected" + "\n");
    }

    public void menuDeselected(MenuEvent e) {
        textArea.append("menuDeselected" + "\n");
    }

    public void menuCanceled(MenuEvent e) {
        textArea.append("menuCanceled" + "\n");
    }

    public void menuKeyTyped(MenuKeyEvent e) {
        textArea.append("menuKeyTyped" + "\n");
    }

    public void menuKeyPressed(MenuKeyEvent e) {
        textArea.append("menuKeyPressed" + "\n");
    }

    public void menuKeyReleased(MenuKeyEvent e) {
        textArea.append("menuKeyReleased" + "\n");
    }
}