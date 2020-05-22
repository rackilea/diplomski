import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableFun extends JPanel {
    public static final String DATA_FILE_PATH = "data.csv";
    private MyTableModel model = new MyTableModel();
    private JTable table = new JTable(model);
    private JTextField fileNameField = new JTextField(DATA_FILE_PATH, 30);
    private JMenuBar menuBar;
    private Action writeModelAction = new WriteModelAction(table, "Write to File", this);
    private Action readModelAction = new ReadModelAction(table, "Read from File", this);

    public TableFun() {
        JPanel btnPanel = new JPanel();
        btnPanel.add(new JLabel("File:"));
        btnPanel.add(fileNameField);
        btnPanel.add(new JButton(writeModelAction));
        btnPanel.add(new JButton(readModelAction));

        table.getColumnModel().getColumn(0).setCellRenderer(new TimeColumnRenderer());
        JScrollPane scrollpane = new JScrollPane(table);
        setLayout(new BorderLayout());
        add(scrollpane);
        add(btnPanel, BorderLayout.PAGE_START);
    }

    public String getFileName() {
        return fileNameField.getText();
    }

    public JMenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            fileMenu.setMnemonic(KeyEvent.VK_F);
            menuBar.add(fileMenu);

            fileMenu.add(new JMenuItem(readModelAction));
            fileMenu.add(new JMenuItem(writeModelAction));
        }
        return menuBar;
    }    

    private static void createAndShowGui() {
        TableFun mainPanel = new TableFun();

        JFrame frame = new JFrame("TableFun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setJMenuBar(mainPanel.getMenuBar());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class WriteModelAction extends AbstractAction {
    private ReadWriteTableData readWriteTableData;
    private TableFun tableFun;

    public WriteModelAction(JTable table, String name, TableFun tableFun) {
        super(name);
        int mnemonic = name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
        readWriteTableData = new ReadWriteTableData(table);
        this.tableFun = tableFun;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File(tableFun.getFileName());
        if (file.exists()) {
            String message = "File " + tableFun.getFileName() + " already exists -- do you wish to overrite?";
            String title = "File Already Exists";
            int optionType = JOptionPane.YES_NO_OPTION;
            int response = JOptionPane.showConfirmDialog(tableFun, message, title, optionType);
            if (response != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            readWriteTableData.write(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}