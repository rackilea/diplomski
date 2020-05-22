import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class ComplexTableEg extends JPanel {
   private CTTableModel tableModel = new CTTableModel();
   private JTable table = new JTable(tableModel);

   public ComplexTableEg() {
      StartProgressAction startProgressAction = new StartProgressAction(
            "Start Progress", KeyEvent.VK_S);
      new ButtonColumn(table, startProgressAction, 0);
      table.getColumnModel().getColumn(2).setCellRenderer(new ProgressRenderer());

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(new JButton(new AddRowAction("Add Row", KeyEvent.VK_A)));

      setLayout(new BorderLayout());
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   private class AddRowAction extends AbstractAction {
      public AddRowAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         int rowCount = tableModel.getRowCount() + 1;
         CTRowData ctRow = new CTRowData("Row " + rowCount);
         tableModel.addRow(ctRow);
      }
   }

   private static void createAndShowGui() {
      ComplexTableEg mainPanel = new ComplexTableEg();

      JFrame frame = new JFrame("Complex Table Eg");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

/**
 * From mKorbel's StackOverflow answer
 * @link: https://stackoverflow.com/a/7036206/522444
 *
 */
class ProgressRenderer extends DefaultTableCellRenderer {
   private final JProgressBar b = new JProgressBar(0, 100);

   public ProgressRenderer() {
       super();
       setOpaque(true);
       b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
   }

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       Integer i = (Integer) value;
       String text = "Completed";
       if (i < 0) {
           text = "Error";
       } else if (i < 100) {
           b.setValue(i);
           return b;
       }
       super.getTableCellRendererComponent(table, text, isSelected, hasFocus, row, column);
       return this;
   }
}

@SuppressWarnings("serial")
class StartProgressAction extends AbstractAction {
   public StartProgressAction(String name, int mnemonic) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JTable table = (JTable) e.getSource();
      int rowIndex = Integer.parseInt(e.getActionCommand());
      CTTableModel model = (CTTableModel) table.getModel();
      CTRowData row = model.getRow(rowIndex);
      row.startProcessing();
   }
}

@SuppressWarnings("serial")
class CTTableModel extends AbstractTableModel {
   public static final String[] COLUMN_HEADERS = { "Button", "Label",
         "Progress" };
   private List<CTRowData> dataList = new ArrayList<>();

   @Override
   public int getRowCount() {
      return dataList.size();
   }

   public CTRowData getRow(int rowIndex) {
      return dataList.get(rowIndex);
   }

   @Override
   public int getColumnCount() {
      return COLUMN_HEADERS.length;
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      CTRowData row = dataList.get(rowIndex);
      switch (columnIndex) {
      case 0:
         return CTRowData.START_PROCESSING;
      case 1:
         return row.getText();
      case 2:
         return row.getValue();
      }
      return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex) {
      switch (columnIndex) {
      case 0:
         return String.class;
      case 1:
         return String.class;
      case 2:
         return Integer.class;
      }
      // should never need this default
      return super.getColumnClass(columnIndex);
   }

   @Override
   public String getColumnName(int column) {
      return COLUMN_HEADERS[column];
   }

   public void addRow(CTRowData row) {
      dataList.add(row);
      int firstRow = dataList.size() - 1;
      fireTableRowsInserted(firstRow, firstRow);

      row.addPropertyChangeListener(new RowDataListener(firstRow));
   }

   private class RowDataListener implements PropertyChangeListener {
      private int row;

      public RowDataListener(int row) {
         this.row = row; 
      }

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (CTRowData.VALUE.equals(evt.getPropertyName())) {
            fireTableCellUpdated(row, 2);
         }
      }
   }

   @Override
   public boolean isCellEditable(int rowIndex, int columnIndex) {
      boolean cellEditable = false;
      if (columnIndex != 0) {
         cellEditable = false;
      } else {
         cellEditable = true;
      }
      return cellEditable;
   }
}

class CTRowData {
   public static final String VALUE = "value";
   public static final String PROCESSING = "processing";
   public static final String START_PROCESSING = "Start Processing";
   private static final int TIMER_DELAY = 500;
   public static final int MAX_VALUE = 100;
   private String text;
   private boolean processing = false;
   private int value = 0;
   private Random random = new Random();
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);

   public CTRowData(String text) {
      this.text = text;
   }

   public boolean isProcessing() {
      return processing;
   }

   public void setProcessing(boolean processing) {
      boolean oldValue = this.processing;
      boolean newValue = processing;
      this.processing = processing;
      pcSupport.firePropertyChange(PROCESSING, oldValue, newValue);
   }

   public void startProcessing() {
      if (processing) {
         return;
      }
      setProcessing(true);
      setValue(0);
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   public String getText() {
      return text;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      int oldValue = this.value;
      int newValue = value;
      this.value = value;
      pcSupport.firePropertyChange(VALUE, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int temp = value;
         temp += 5 + random.nextInt(10);
         temp = Math.min(temp, MAX_VALUE);
         setValue(temp);
         if (temp >= MAX_VALUE) {
            ((Timer) e.getSource()).stop();
            setProcessing(false);
         }
      }
   }
}