model.addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
        int type = e.getType();
        switch (type) {
            case TableModelEvent.UPDATE:
                if (e.getFirstRow() - e.getLastRow() == 0) {
                    TableModel model = (TableModel) e.getSource();
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    System.out.println("Update " + row + "x" + col + " = " + model.getValueAt(row, col));
                }
                break;
        }
    }
});