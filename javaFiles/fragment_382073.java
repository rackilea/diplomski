import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class TabbedTest extends JFrame {

    private JTabbedPane tabbedPane = null;
    private MouseListener tabbedPaneMouseListener = null;
    private ArrayList<String> nameOfTab = new ArrayList<String>();
    private static int counter = 1;

    public TabbedTest() {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElementToArrayList();
            }
        });
        JButton removeButton = new JButton("remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeElementFromArrayList();
            }
        });

        tabbedPane = new JTabbedPane();
        tabbedPaneMouseListener = (new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (e.getClickCount() == 1) {
                        System.out.println("Do Something");
                    }
                }
            }
        });
        tabbedPane.addMouseListener(tabbedPaneMouseListener);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        add(buttonPanel);
        this.add(tabbedPane);
    }

    private void addElementToArrayList() {
        nameOfTab.add("" + counter++ + ". element");
        updateTabbedPane();
    }

    private void removeElementFromArrayList() {
        if (nameOfTab.size() > 0) {
            nameOfTab.remove(0);
        }
        updateTabbedPane();
    }

    public void updateTabbedPane() {
        tabbedPane.removeMouseListener(tabbedPaneMouseListener);
        while (tabbedPane.getTabCount() > 0) {
            tabbedPane.remove(0);
        }
        for (int i = 0; i < nameOfTab.size(); i++) {
            tabbedPane.addTab(nameOfTab.get(i), new JLabel(nameOfTab.get(i)));
        }
        tabbedPane.addMouseListener(tabbedPaneMouseListener);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TabbedTest().setVisible(true);
            }
        });
    }
}