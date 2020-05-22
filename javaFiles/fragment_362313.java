private static final int DESIRED_ROW = …;

@Override
public boolean isCellEditable(int row, int column) {
    return row == DESIRED_ROW;
}