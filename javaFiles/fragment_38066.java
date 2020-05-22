import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisabledCombo2 {
  public static JComponent makeUI() {
    DisabledSupportComboModel model = new DisabledSupportComboModel();
    model.addElement(new Item("First element"));
    model.addElement(new Item("Second element"));
    model.addElement(new Item("Disabled", false));
    model.addElement(new Item("Fourth element"));

    JComboBox<Item> itemCombo = new JComboBox<Item>(model) {
      //@see http://java-swing-tips.blogspot.jp/2010/03/non-selectable-jcombobox-items.html
      private boolean isDisableIndex;
      @Override public void setPopupVisible(boolean v) {
        if (!v && isDisableIndex) {
          //Do nothing(prevent the combo popup from closing)
          isDisableIndex = false;
        } else {
          super.setPopupVisible(v);
        }
      }
      @Override public void setSelectedObject(Object o) {
        if (o instanceof Item && !((Item) o).isEnabled()) {
          isDisableIndex = true;
        } else {
          super.setSelectedObject(o);
        }
      }
      @Override public void setSelectedIndex(int index) {
        Object o = getItemAt(index);
        if (o instanceof Item && !((Item) o).isEnabled()) {
          isDisableIndex = true;
        } else {
          super.setSelectedIndex(index);
        }
      }
    };
    itemCombo.setRenderer(new DisabledSupportComboRenderer());
    return itemCombo;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame("Combo test2");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(makeUI());
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class Item {
  private final Object value;
  private final boolean enabled;

  public Item(Object aValue) {
    value = aValue;
    enabled = true;
  }
  public Item(Object aValue, boolean isEnabled) {
    value = aValue;
    enabled = isEnabled;
  }
  public Object getValue() {
    return value;
  }
  public boolean isEnabled() {
    return enabled;
  }
  @Override public String toString() {
    return null == value ? null : value.toString();
  }
}

class DisabledSupportComboModel extends DefaultComboBoxModel<Item> {
  @Override public void setSelectedItem(Object anObject) {
    if (anObject instanceof Item) {
      if (((Item) anObject).isEnabled()) {
        super.setSelectedItem(anObject);
      }
    } else {
      super.setSelectedItem(anObject);
    }
  }
}

class DisabledSupportComboRenderer extends DefaultListCellRenderer {
  @Override public Component getListCellRendererComponent(
      JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value instanceof Item) {
      if (((Item) value).isEnabled()) {
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
      } else {
        setForeground(UIManager.getColor("Label.disabledForeground"));
        setBackground(list.getBackground());
      }
    } else {
      setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
      setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
    }
    return this;
  }
}