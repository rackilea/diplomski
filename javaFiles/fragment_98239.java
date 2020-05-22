package com.zetcode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

public class HotelReservationSystemEx extends JFrame {

    private JTable table;

    public HotelReservationSystemEx() {

        initUI();
    }

    private void initUI() {

        String[] columns = {"Name", "Age", "Gender"};

        String[][] data = {{"John", "18", "Male"},
        {"Daisy", "19", "Female"},
        {"Dave", "23", "Male"},
        {"Jake", "30", "Male"}};

        table = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }

            @Override
            public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                Component c = super.prepareRenderer(r, data, columns);

                if ((data % 2 == 0)) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(Color.LIGHT_GRAY);
                }

                return c;
            }
        };

        //table.setFillsViewportHeight(true);

        JScrollPane spane = new JScrollPane(table);

        createLayout(spane);

        setTitle("Hotel reservation system");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            HotelReservationSystemEx ex = new HotelReservationSystemEx();
            ex.setVisible(true);
        });
    }
}