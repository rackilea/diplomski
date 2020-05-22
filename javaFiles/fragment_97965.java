import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MultiLineCellEditorTest {
  public JComponent makeUI() {
    String[] columnNames = {"JTextField", "JTextArea"};
    Object[][] data = {
      {"aaa", "JTextArea+JScrollPane\nCtrl-Enter: stopCellEditing"},
      {"bbb", "ggg"}, {"ccccDDD", "hhh\njjj\nkkk"}
    };
    TableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return String.class;
      }
    };
    JTable table = new JTable(model) {
      @Override public void updateUI() {
        super.updateUI();
        TableColumn col = getColumnModel().getColumn(1);
        col.setCellEditor(new TextAreaCellEditor());
        col.setCellRenderer(new TextAreaCellRenderer());
      }
    };
    table.setAutoCreateRowSorter(true);
    table.setSurrendersFocusOnKeystroke(true);
    table.setRowHeight(64);
    return new JScrollPane(table);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new MultiLineCellEditorTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
class TextAreaCellRenderer implements TableCellRenderer {
  private final JTextArea textArea = new JTextArea();
  public TextAreaCellRenderer() {
    textArea.setLineWrap(true);
    textArea.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
  }
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    if (isSelected) {
      textArea.setForeground(table.getSelectionForeground());
      textArea.setBackground(table.getSelectionBackground());
    } else {
      textArea.setForeground(table.getForeground());
      textArea.setBackground(table.getBackground());
    }
    textArea.setFont(table.getFont());
    textArea.setText(Objects.toString(value, ""));
    return textArea;
  }
}
//class TextAreaCellEditor extends AbstractCellEditor implements TableCellEditor {
class TextAreaCellEditor implements TableCellEditor {
  private static final String KEY = "Stop-Cell-Editing";
  private final JScrollPane scroll;
  private final JTextArea textArea = new JTextArea();
  public TextAreaCellEditor() {
    //super();
    scroll = new JScrollPane(textArea);
    scroll.setBorder(BorderFactory.createEmptyBorder());
    textArea.setLineWrap(true);
    textArea.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
    KeyStroke enter = KeyStroke.getKeyStroke(
        KeyEvent.VK_ENTER, InputEvent.CTRL_MASK);
    textArea.getInputMap(JComponent.WHEN_FOCUSED).put(enter, KEY);
    textArea.getActionMap().put(KEY, new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        stopCellEditing();
      }
    });
  }
  @Override public Object getCellEditorValue() {
    return textArea.getText();
  }
  @Override public Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected, int row, int column) {
    System.out.println("2. getTableCellEditorComponent");
    textArea.setFont(table.getFont());
    textArea.setText(Objects.toString(value, ""));
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        textArea.setCaretPosition(textArea.getText().length());
        textArea.requestFocusInWindow();
        System.out.println("4. invokeLater: getTableCellEditorComponent");
      }
    });
    return scroll;
  }
  @Override public boolean isCellEditable(final EventObject e) {
    if (e instanceof MouseEvent) {
      return ((MouseEvent) e).getClickCount() >= 2;
    }
    System.out.println("1. isCellEditable");
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        if (e instanceof KeyEvent) {
          KeyEvent ke = (KeyEvent) e;
          char kc = ke.getKeyChar();
          if (Character.isUnicodeIdentifierStart(kc)) {
            textArea.setText(textArea.getText() + kc);
            System.out.println("3. invokeLater: isCellEditable");
          }
        }
      }
    });
    return true;
  }

  //Copid from AbstractCellEditor
  protected EventListenerList listenerList = new EventListenerList();
  transient protected ChangeEvent changeEvent = null;
  @Override public boolean shouldSelectCell(EventObject e) {
    return true;
  }
  @Override public boolean stopCellEditing() {
    fireEditingStopped();
    return true;
  }
  @Override public void cancelCellEditing() {
    fireEditingCanceled();
  }
  @Override public void addCellEditorListener(CellEditorListener l) {
    listenerList.add(CellEditorListener.class, l);
  }
  @Override public void removeCellEditorListener(CellEditorListener l) {
    listenerList.remove(CellEditorListener.class, l);
  }
  public CellEditorListener[] getCellEditorListeners() {
    return listenerList.getListeners(CellEditorListener.class);
  }
  protected void fireEditingStopped() {
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // Process the listeners last to first, notifying
    // those that are interested in this event
    for(int i = listeners.length-2; i>=0; i-=2) {
      if(listeners[i]==CellEditorListener.class) {
        // Lazily create the event:
        if(changeEvent == null) changeEvent = new ChangeEvent(this);
        ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
      }
    }
  }
  protected void fireEditingCanceled() {
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // Process the listeners last to first, notifying
    // those that are interested in this event
    for(int i = listeners.length-2; i>=0; i-=2) {
      if(listeners[i]==CellEditorListener.class) {
        // Lazily create the event:
        if(changeEvent == null) changeEvent = new ChangeEvent(this);
        ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
      }
    }
  }
}