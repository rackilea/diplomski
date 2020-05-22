import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.*;

public class TableExample {
    private static void createAndShowGui() {
        TablePanel tablePanel = new TablePanel();
        JMenuItem fillTableItem = new JMenuItem(new FillTableAction(tablePanel));
        JMenuItem clearTableItem = new JMenuItem(new ClearTableAction(tablePanel));

        JMenu tableMenu = new JMenu("Table Actions");
        tableMenu.setMnemonic(KeyEvent.VK_T);
        tableMenu.add(fillTableItem);
        tableMenu.add(clearTableItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(tableMenu);

        JFrame frame = new JFrame("TableExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(tablePanel);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}