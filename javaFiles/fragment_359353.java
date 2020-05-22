import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class KeyValueComboboxModel extends AbstractListModel implements ComboBoxModel, Map<String, String> {

    private TreeMap<String,String> values = new TreeMap<String,String>();

    private Map.Entry<String, String> selectedItem = null;

    public Object getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Object anItem) {
        this.selectedItem = (java.util.Map.Entry<String, String>) anItem;
        fireContentsChanged(this, -1, -1);
    }

    public Object getElementAt(int index) {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(values.entrySet());
        return list.get(index);
    }



    public int getSize() {
        return values.size();
    }

    public void clear() {
        values.clear();
    }

    public boolean containsKey(Object key) {
        return values.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

    public Set<java.util.Map.Entry<String, String>> entrySet() {
        return values.entrySet();
    }

    public String get(Object key) {
        return values.get(key);
    }

    public Set<String> keySet() {
        return values.keySet();
    }

    public String put(String key, String value) {
        return values.put(key, value);
    }

    public String remove(Object key) {
        return values.remove(key);
    }

    public int size() {
        return values.size();
    }

    public Collection<String> values() {
        return values.values();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public void putAll(Map<? extends String, ? extends String> m) {
        values.putAll(m);
    }


    private static String entryToString(Map.Entry<String, String> entry) {
        String str = "" + entry.getKey() + "->" + entry.getValue();
        return str;
    }

    public static void main(String[] args) {

        Map<String,String> map= new HashMap<String,String>(){{
            put("1","blue");
            put("2","red");
            put("3","white");
            put("4","black");
        }};

        JFrame f = new JFrame();
        f.setContentPane(new JPanel(new BorderLayout()));

        KeyValueComboboxModel model = new KeyValueComboboxModel();
        model.putAll(map);

        final JComboBox combo = new JComboBox(model);
        combo.setRenderer(new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                    Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        });

        final JLabel lab = new JLabel("Nothing selected");

        combo.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                if(combo.getSelectedItem()!=null){
                    lab.setText(entryToString((java.util.Map.Entry<String, String>) combo.getSelectedItem()));
                } else {
                    lab.setText("");
                }

            }

        });

        f.getContentPane().add(combo,BorderLayout.CENTER);
        f.getContentPane().add(lab,BorderLayout.SOUTH);

        f.setSize(300,80);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }


}