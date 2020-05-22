import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class DialogStringEditor extends AbstractCellEditor
        implements TableCellEditor,
        ActionListener
{

    String newInput;
    String oldValue;
    JButton button;
    static final String EDIT = "edit";

    public DialogStringEditor()
    {
        button = new JButton();
        button.setBackground(Color.WHITE);
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (EDIT.equals(e.getActionCommand()))
        {
            newInput = JOptionPane.showInputDialog("Edit", oldValue);
            if (newInput == null)
            {
                newInput = oldValue;
            }
            fireEditingStopped();
        }
    }

    @Override
    public Object getCellEditorValue()
    {
        return newInput;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column)
    {
        newInput = (String) value;
        oldValue = (String) value;
        return button;
    }
}