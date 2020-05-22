@Override
public Object getValueAt(int row, int column) {
    final RowData row = this.rowData.get(row);

    switch (column){
        case 0: return row.getModule().getIdentifier();
        case 1: return row.getModule().getTitle();
        case 2: return row.getAssignment().getTitle();
        case 3: return row.getAssignment().Author();
        case 4: return row.getAssignment().getSet();
        case 5: return row.getAssignment().getDue();
        case 6: return row.getAssignment().getWeighting();
        default: return null;
    }
}