class SpecialComboBoxModel extends DefaultComboBoxModel {
    public final static String NULL_ELEMENT = "<None>";

    public SpecialComboBoxModel(Vector v) {
        super(v);
    }

    @Override
    public int getSize() {
        return super.getSize() + 1;
    }

    @Override
    public Object getElementAt(int index) {
        if( index == 0) {
            return NULL_ELEMENT;
        }
        return super.getElementAt(index - 1);
    }
}


    ArrayList<String> yourArrayList = new ArrayList<String>();
    yourArrayList.add("Value1");
    yourArrayList.add("Value2");
    Vector<String> v = new Vector<String>(yourArrayList);
    dropdown.setModel(new SpecialComboBoxModel(v));