private boolean filledFromExcel;

public boolean isCellEditable(int row, int column) {
    if (column == HIDDEN_INDEX || column == AN_INDEX || column == ID_INDEX)
        return false;
    else
        return !filledFromExcel;
}