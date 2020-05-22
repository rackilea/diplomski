pm = new JPopupMenu();
pm.add(one);
pm.add(two);
one.addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent me) {
        if(row != -1)
        System.out.println("sfsdf" + row);

    }

});

two.addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent me) {
        if(row != -1){
            Object valueAt = table.getValueAt(row,1);
            table.setValueAt(valueAt+"Solved", row,1);
            ((DefaultTableModel)table.getModel()).fireTableDataChanged();
        }
    }

});