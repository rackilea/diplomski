public boolean moves(int row , int column , int value) {
    value += 48;
    if (list.get(row).charAt(column) == '.'){
        StringBuilder sb = new StringBuilder(list.get(row));
        sb.setCharAt(column, (char)value);
        list.set(row, sb.toString());
        return true;
    }
    else {
        return false;
    }
}