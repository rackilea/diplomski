package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

public class MigLayoutEx extends JFrame {

    private JComboBox cityBox;
    private JTable filterTable;

    public MigLayoutEx() {

        initUI();
    }

    private void initUI() {

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        add(tabbedPane);

        filterTable = createTable();
        cityBox = createCityBox();

        JPanel pnl = new JPanel(new MigLayout(""));
        pnl.add(new JLabel("City"), "split 2");
        pnl.add(cityBox, "wrap");

        pnl.add(new JScrollPane(filterTable));

        tabbedPane.addTab("Test", pnl);
        pack();

        setTitle("MigLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTable createTable() {

        String[] columnNames = {"Cities"};
        String[][] data = {
            {"NY"}, {"NY"}, {"NY"}, {"NY"}, {"LA"}, {"LA"}, {"Columbia"},
            {"DC"}, {"DC"}, {"DC"}, {"DC"}, {"DC"}, {"DC"}
        };

        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        return table;
    }

    private JComboBox createCityBox() {

        String[] fillings = {"NY", "LA", "Columbia", "DC"};
        JComboBox box = new JComboBox(fillings);

        return box;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutEx ex = new MigLayoutEx();
                ex.setVisible(true);
            }
        });
    }
}