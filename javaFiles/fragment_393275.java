public Object getValueAt(int row, int column) {
    if (column == 0) {
        return this.list.get(row);
    }
    else {
        return row;
    }
}

public int getRowCount() {
    return this.list.size();
}

public int getColumnCount() {
    return 2;
}