package com.logicbig.example;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class IncorrectRowHeight extends JPanel {
private static final Font font = new Font("SansSerif", Font.PLAIN, 30);
private class MyCellRenderer extends JTextField implements TableCellRenderer {
    private MyCellRenderer() {
        setFont(font);
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setText(value.toString());
        return this;
    }
}

public IncorrectRowHeight() {
    super(new BorderLayout());

    add(new JTextField(25), BorderLayout.PAGE_START);

    String[][] data = {
            {"a", "b", "c", "d", "e"},
            {"f", "g", "h", "i", "j"},
            {"k", "l", "m", "n", "o"},
            {"p", "q", "r", "s", "t"}
    };
    String[] cols = {"h1", "h2", "h3", "h4", "h5"};
    JTable t = new JTable(data, cols);
    t.setRowHeight(t.getFontMetrics(font).getHeight());
    t.setGridColor(Color.GRAY);
    t.setPreferredScrollableViewportSize(new Dimension(300, 65));
    TableColumnModel model = t.getColumnModel();
    for (int i = 0; i < model.getColumnCount(); i++) {
        TableColumn column = model.getColumn(i);
        column.setCellRenderer(new MyCellRenderer());
    }
    JScrollPane scroller = new JScrollPane(t);
    add(scroller, BorderLayout.CENTER);

    //t.doLayout();  // doesn't help matters
}

private static void createAndShowGUI() {
    JFrame frame = new JFrame("IncorrectRowHeight");
    JComponent newContentPane = new IncorrectRowHeight();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);
    frame.pack();
    frame.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
  }
 }