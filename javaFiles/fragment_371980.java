public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getName();

        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            return list.get(rowIndex).getNumber(columnIndex - 1);

        default:
            return null;
    }
}