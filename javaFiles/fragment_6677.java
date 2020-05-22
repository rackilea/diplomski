public class TreeNodeModel {

    int key;
    String value;
    boolean isSelected=false;
    boolean hasCheckBox=false;

    public TreeNodeModel() {
    }
    public TreeNodeModel(int key, String value) {
        this.key=key;
        this.value = value;
    }
    public TreeNodeModel(int key, String value, boolean hasCheckBox) {
        this.key=key;
        this.value = value;
        this.hasCheckBox = hasCheckBox;
    }
    public TreeNodeModel(int key, String value, boolean hasCheckBox, boolean isSelected) {
        this.key=key;
        this.value = value;
        this.hasCheckBox=hasCheckBox;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return this.isSelected;
    }
    public void setSelected(boolean newValue) {
        this.isSelected = newValue;
    }

    public boolean hasCheckBox() {
        return this.hasCheckBox;
    }
    public void setCheckBox(boolean newValue) {
        this.hasCheckBox=newValue;
    }

    public int getKey() {
        return this.key;
    }
    public void setKey(int newValue) {
        this.key = newValue;
    }

    public String getValue() {
        return this.value;
    }
    public void setValue(String newValue) {
        this.value = newValue;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" + this.value + "/" + this.isSelected + "]";
//        return this.text;
    }

}