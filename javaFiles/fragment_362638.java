public int getRowCount() { 
    return list.size();
}

public int getColumnCount() {
    return 5; 
}

public Object getValueAt(int row, int col) {
    Employee employee = list.get(row);
    if (col == 0) {
        return e.getName();
    }
    else if (col == 1) {
        return e.getGrade();
    }
    ...
}