public void addRows (ArrayList<Object[]> rows) {
    for (int i = 0; i < rows.size(); i++) {
        Object[] clone = rows.get(i).clone();
        data.add(clone);
    }
    fireTableDataChanged();
}