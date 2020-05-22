package com.zetcode;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class GroupLayoutEx extends JFrame {

    private JComboBox cityBox;
    private JTable filterTable;

    public GroupLayoutEx() {

        initUI();
    }

    private void initUI() {

        JPanel pnl = new JPanel();
        GroupLayout gl = new GroupLayout(pnl);
        pnl.setLayout(gl);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        add(tabbedPane);

        JLabel cityLbl = new JLabel("City");
        filterTable = createTable();
        JScrollPane spane = new JScrollPane(filterTable);
        cityBox = createCityBox();

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(cityLbl)
                        .addComponent(cityBox))
                .addComponent(spane)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(cityLbl)
                        .addComponent(cityBox))
                .addComponent(spane)
        );

        tabbedPane.addTab("Test", pnl);
        pack();

        setTitle("GroupLayout example");
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
                GroupLayoutEx ex = new GroupLayoutEx();
                ex.setVisible(true);
            }
        });
    }
}