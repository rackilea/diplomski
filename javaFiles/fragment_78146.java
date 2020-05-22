public class TestModel extends ... { // Some TableModel

    //...

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            // Set the value been passed to in (probably from the editor)...            
            fireTableCellUpdated(rowIndex, columnIndex);
            BigDecimal amount = new BigDecimal(String.valueOf(getValueAt(rowIndex, 3)).replace(",", "."));
            BigDecimal price = new BigDecimal(String.valueOf(getValueAt(rowIndex, 4)).replace(",", "."));
            BigDecimal withoutTax = amount.multiply(price, new MathContext(2));
            // Set the value for row x 5 directly within the backing store of the model...
            //table.setValueAt(withoutTax, i, 5);
            BigDecimal tax = withoutTax.multiply(new BigDecimal(0.23), new MathContext(2));
            // Set the value for row x 7 directly within the backing store of the model...
            //table.setValueAt(tax, i, 7);
            BigDecimal withTax = withoutTax.add(tax, new MathContext(2));
            // Set the value for row x 8 directly within the backing store of the model...
            //table.setValueAt(withTax, i, 8);

            fireTableCellUpdated(rowIndex, 5);
            fireTableCellUpdated(rowIndex, 7);
            fireTableCellUpdated(rowIndex, 8);

            // It might actually be easier to use...
            //fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }