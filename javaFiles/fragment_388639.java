package PiggeryManagementSystem;

import java.util.ArrayList;
import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * @author Stanchart
 */
public class MyComboBoxModel  implements MutableComboBoxModel {

    private Object selectedItem;     
    ArrayList <String> columns = new ArrayList();

    public MyComboBoxModel( ArrayList<String> c) {
       this.columns = c;
    }

    @Override
    public void addElement(Object item) {
        columns.add(item.toString());
    }

    @Override
    public void removeElement(Object obj) {
        columns.remove(obj.toString());
    }

    @Override
    public void insertElementAt(Object item, int index) {
        columns.get(index);
    }

    @Override
    public void removeElementAt(int index) {
        columns.remove(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;   
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return columns.size();
    }

    @Override
    public Object getElementAt(int index) {
        return columns.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }    
}