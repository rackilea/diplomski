@Override
public Object getValueAt(int rowIndex, int columnIndex) {
     switch (columnIndex) {
     case 0:
            return data.get(rowIndex).getValueX; // Change to however you'd like to call a single value from your map
     case 1:
            return data.get(rowIndex).getValueY;
     case 2:
            return data.get(rowIndex).getValueZ;
     default:
            throw new IndexOutOfBoundsException();
     }
}