import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;

public class SciCalc {

    private static void createAndShowUI() {
        SciCalcGui gui = new SciCalcGui();
        SciCalcMenu menu = new SciCalcMenu(gui);
        JFrame frame = new JFrame("Calculator");
        frame.getContentPane().add(gui.getMainPanel());
        frame.setJMenuBar(menu.getJMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }

    private SciCalc() {
    }
}

class SciCalcGui {

    private static final String[][] STANDARD_BTN_TEXTS = {
        {"7", "8", "9", "/"}, {"4", "5", "6", "*"},
        {"1", "2", "3", "-"}, {"0", ".", "=", "+"}};
    private static final String[][] SCIENTIFIC_BTN_TEXTS = {
        {"sqrt", "1/x", "sin"}, {"%", "Exp", "cos"},
        {"x^y", "ln", "tan"}, {"x^2", "n!", "sec"}};
    private static final int GAP = 5;
    private static final Font BTN_FONT = new Font(Font.DIALOG, Font.BOLD, 20);
    private JPanel mainPanel = new JPanel();
    private JPanel sciPanel;
    private JTextField display = new JTextField();

    SciCalcGui() {
        display.setFont(BTN_FONT);
        JPanel standardPanel = createBtnPanel(STANDARD_BTN_TEXTS, "Standard");
        sciPanel = createBtnPanel(SCIENTIFIC_BTN_TEXTS, "Scientific");
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        mainPanel.add(standardPanel, BorderLayout.CENTER);
        mainPanel.add(sciPanel, BorderLayout.WEST);
        mainPanel.add(display, BorderLayout.NORTH);
        sciPanel.setVisible(false);
    }

    public void sciPanelSetVisible(boolean visible) {
        sciPanel.setVisible(visible);
        Window win = SwingUtilities.getWindowAncestor(mainPanel);
        win.pack();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel createBtnPanel(String[][] texts, String title) {
        JPanel btnPanel = new JPanel();
        int rows = texts.length;
        int cols = texts[0].length;
        btnPanel.setLayout(new GridLayout(rows, cols, GAP, GAP));
        for (int row = 0; row < texts.length; row++) {
            for (int col = 0; col < texts[row].length; col++) {
                JButton btn = new JButton(texts[row][col]);
                btn.setFont(BTN_FONT);
                btnPanel.add(btn);
            }
        }
        btnPanel.setBorder(BorderFactory.createTitledBorder(title));
        return btnPanel;
    }
}

class SciCalcMenu {

    private static final String STANDARD = "Standard";
    private static final String SCIENTIFIC = "Scientific";
    private SciCalcGui gui;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem standardView;
    private JMenuItem scientificView;

    SciCalcMenu(SciCalcGui gui) {
        this.gui = gui;
        standardView = new JMenuItem(STANDARD, KeyEvent.VK_T);
        scientificView = new JMenuItem(SCIENTIFIC, KeyEvent.VK_S);
        ViewAction viewAction = new ViewAction();
        standardView.addActionListener(viewAction);
        scientificView.addActionListener(viewAction);
        standardView.setEnabled(false);
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);
        viewMenu.add(standardView);
        viewMenu.add(scientificView);
        menuBar.add(new JMenu("Edit"));
        menuBar.add(viewMenu);
        menuBar.add(new JMenu("Help"));
    }

    public JMenuBar getJMenuBar() {
        return menuBar;
    }

    private class ViewAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals(STANDARD)) {
                gui.sciPanelSetVisible(false);
                standardView.setEnabled(false);
                scientificView.setEnabled(true);
            } else if (command.equals(SCIENTIFIC)) {
                gui.sciPanelSetVisible(true);
                standardView.setEnabled(true);
                scientificView.setEnabled(false);
            }
        }
    }
}