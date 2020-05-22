Form form = new Form();
    form.setLayout(new BorderLayout());
    ValueBeans[] valueBeans = new ValueBeans[size];     
    // Here you can use Bean array value. This array contains collection of bean class. 
    // You can get the values from this beans class. 
    // You need to create dynamically with your own staff

    Object[][] arrObj = new Object[valueBeans.length, 3];

    TableModel model = new DefaultTableModel(new String[]{"Column 1", "Column 2", "Column 3"}, arrObj) {

      public boolean isCellEditable(int row, int col) {
        return false; // return true if editable cell
         }
      };

for (int index = 0; index < rowValues.size(); index++) {                                   
    model.setValueAt(index, 0, valueBeans[index].getValue1()); // row , column , value
    model.setValueAt(index, 1, valueBeans[index].getValue2()); 
    model.setValueAt(index, 2, valueBeans[index].getValue3()); 
}

    Table table = new Table(model) {

    protected Component createCell(Object value, final int row, final int column, boolean editable) {

    final Component c = super.createCell(value, row, column, editable);
    c.setFocusable(false);
    return c;
     }
    };
    table.setScrollable(false);
    form.addComponent(BorderLayout.CENTER, table);