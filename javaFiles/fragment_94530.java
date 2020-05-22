private int index;
private String name;
private String col;

public ComboItem(int pindex, String pName) {
    this.index = pindex;
    this.name = pName;
}

public ComboItem(int pindex, String pcol, String pName) {
    this.index = pindex;
    this.col = pcol;
    this.name = pName;

}

public int GetIndex() {
    return this.index;
}

public String GetName() {
    return this.name;
}

public String GetCol() {
    return this.col;
}

public int SetIndex(int pindex) {
    this.index = pindex;
    return pindex;
}

public String SetName(String pName) {
    this.name = pName;
    return pName;
}

public String SetCol(String pCol) {
    this.col = pCol;
    return pCol;
}

// This will be used internally by JComboBox as the label to be displayed.
@Override
public String toString() {
    return name;
}

// to get the Index of Combobox depends on ComboItem Class
public static int getIndexById(JComboBox combo, int id) {

    for (int i = 1; i < combo.getItemCount(); i++) {
        try {
            ComboItem c = (ComboItem) combo.getItemAt(i);
            int tempId = c.GetIndex();
            if (tempId == id) {
                return i;
            }
        } catch (Exception e) {

        }
    }
    return 0;
}