public boolean isCellEditable(int row, int col) {
    if (col == someInt) {
        return true;
    } else if (col == TableColumnsStartsWithZero) {
        return true;
    } else {
        return false;
    }
}