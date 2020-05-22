package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import model.DAO.TableDAO;
import model.VO.VTableVO;

public class FrmExample extends javax.swing.JInternalFrame {

    public FrmExample() throws SQLException, ClassNotFoundException {

        initComponents();
        getTableModel();
        getTable();
        txtId.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(ActionEvent e) {
                searchId();
            }
        });
        TableExample.setAutoCreateRowSorter(true);

    }

    private  void getTableModel() {

        // Configure the columns of JTable
        TableColumnModel columnModel =
                this.TableExample.getColumnModel();

        columnModel.getColumn(0).setHeaderValue("ID");
        columnModel.getColumn(0).setPreferredWidth(60);

        columnModel.getColumn(1).setHeaderValue("Name");
        columnModel.getColumn(1).setPreferredWidth(180);

        columnModel.getColumn(2).setHeaderValue("Birth Date");
        columnModel.getColumn(2).setPreferredWidth(180);

    }

    private JTable getTable() throws ClassNotFoundException {

        String[] columnTitles = { "ID", "Name", "Birth Date" };
        List<VTableVO> listExample = new TableDAO().List();
        Object[][] data = new Object[listExample.size()][columnTitles.length];

        for(VTableVO vo : list) {
                    data[list.indexOf(vo)][0] = "" + vo.getId();
                    data[list.indexOf(vo)][1] =      vo.getName();
                    data[list.indexOf(vo)][2] = "" + vo.getBirthdate();
        } // Is there a way to code that so it become more dynamic? Writing 1 line instead of 3

        DefaultTableModel model = new DefaultTableModel(data, columnTitles) {
            @Override
            public Class getColumnClass(int col) {
                Object obj = getValueAt(0, col);
                if(obj == null)
                    return Object.class;
                else
                    return obj.getClass();
            }
        };

        TableExample.setDefaultRenderer(String.class, new CustomRenderer());
        TableExample.setRowSelectionAllowed(true);
        TableExample.setColumnSelectionAllowed(true);
        TableExample.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableExample.setModel(model);

        TableModel model = TableExample.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        TableExample.setRowSorter(sorter);

        return TableExample;

    }

    private void searchId() {

        String target = txtId.getText();
        for(int row = 0; row < TableExample.getRowCount(); row++) {
            String next = (String)TableExample.getValueAt(row, 0); // First row only
                if(next.equals(target)) {
                    displayResultSearch(row, 0);
                    return;
                }
        }

        CustomRenderer renderer = (CustomRenderer)TableExample.getDefaultRenderer(String.class);
        renderer.setTargetCell(-1, -1);
        TableExample.repaint();

    }

    private void displayResultSearch(int row, int column) {
        CustomRenderer renderer = (CustomRenderer)TableExample.getCellRenderer(row, column);
        renderer.setTargetCell(row, column);
        Rectangle rect = TableExample.getCellRect(row, column, false);
        TableExample.scrollRectToVisible(rect);
        TableExample.repaint();
    }

class CustomRenderer implements TableCellRenderer {

    JLabel label;
    int targetRow, targetColumn;

    public CustomRenderer() {

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        targetRow = -1;
        targetColumn = -1;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {

        if(isSelected) {
            label.setBackground(table.getSelectionBackground());
            label.setForeground(table.getSelectionForeground());
        } else {
            label.setBackground(table.getBackground());
            label.setForeground(table.getForeground());
        }
        if(row == targetRow && column == targetColumn) {
            label.setBorder(BorderFactory.createLineBorder(Color.red)); // Color it in RED!
            label.setFont(table.getFont().deriveFont(Font.BOLD)); // And BOLD!
        } else {
            label.setBorder(null);
            label.setFont(table.getFont());
        }
        label.setText((String)value);
        return label;

    }

    public void setTargetCell(int row, int column) {

        targetRow = row;
        targetColumn = column;

    }

  }

}