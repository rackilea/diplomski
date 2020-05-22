package test;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListDataListener;

public class ComboMain {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JComboBox<Artikel> cmb = new JComboBox<Artikel>(
                new ComboBoxModelArtikel(null, readFromArtikel()));
        cmb.setRenderer(new ArtikelListRenderer());
        f.add(cmb);
        f.setSize(new Dimension(200, 200));
        f.setVisible(true);
    }

    public static List<Artikel> readFromArtikel() {
        List<Artikel> a = new ArrayList<Artikel>();
        a.add(new Artikel("id", "name"));
        a.add(new Artikel("id1", "name1"));
        return a;
    }

}

class Artikel {
    String id;
    String name;

    public Artikel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}


class ArtikelListRenderer extends JLabel implements ListCellRenderer<Artikel> {

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Artikel> list, Artikel value, int index,
            boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            Artikel artikels = (Artikel) value;
            setText(artikels.getName());
        } else {
            setText("Please select an item");
        }

        return this;
    }
}

class ComboBoxModelArtikel implements ComboBoxModel<Artikel> {
    private Object selectedItem;
    List<Artikel> lstArtikels;
    private Object panel;

    public ComboBoxModelArtikel(Object panel, List<Artikel> artikels) {
        this.panel = panel;
        this.lstArtikels = artikels;
    }

    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    public Object getSelectedItem() {
        return selectedItem;
    }

    public int getSize() {
        return lstArtikels.size();
    }

    public Artikel getElementAt(int index) {
        return lstArtikels.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        // Todo:
    }

    public void removeListDataListener(ListDataListener l) {
        // Todo:
    }
}