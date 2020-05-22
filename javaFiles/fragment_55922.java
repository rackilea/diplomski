public void tableUpdate(int row, Member m) {
    if (row < members.size()) {
        members.set(row, m);
        fireTableRowsUpdated(row, row);
    }
}