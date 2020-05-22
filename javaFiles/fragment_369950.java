table = new JTable();
    //I override the getValueAt see @mKorbel comments so that columns 5
    //return the value of 3*4 (you should not to calculate and set this from   
    //the listener, setting the value will recall the listener again)
    table.setModel(new DefaultTableModel() {

        @Override
        public Object getValueAt(int row, int column) {
            if (column == 5) {
                Object price = super.getValueAt(row, 3);
                Object quantity = super.getValueAt(row, 4);
                if (price instanceof Number && quantity instanceof Number) {
                    return ((Number) price).doubleValue() * ((Number) quantity).intValue();

                }
                return 0d;
            }
            return super.getValueAt(row, column);
        }

    });

    //I use the listener to understand if column 3 or 4 is changed
    //to recalculate my totale. I have also added code to detect inseration/delation of rows.
    table.getModel().addTableModelListener(new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent ev) {
            switch(ev.getType()){
            case TableModelEvent.UPDATE:
                if (ev.getColumn() == 3 || ev.getColumn() == 4) {
                    calculateTotale();
                }
                return;
            case TableModelEvent.INSERT:
            case TableModelEvent.DELETE:
                calculateTotale();
                break;
            }
        }
    });
}

//Simple metod to calculate the total and set it to the JTextField.
public void calculateTotale() {
    double tot = 0d;
    int numOfRows = table.getRowCount();
    for (int i = 0; i < numOfRows; i++) {
        Object cost = table.getValueAt(i, 5);
        if (cost instanceof Number) {
            tot += ((Number) cost).doubleValue();
        }
    }
    totalField.setText(NumberFormat.getNumberInstance().format(tot));
    System.out.println("I DID IT!!");
}