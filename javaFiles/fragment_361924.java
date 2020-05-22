DefaultTableModel  dtm = new DefaultTableModel(data, colName);{
    public Class getColumnClass(int c) {
        switch (c) {
            case 0: return Boolean.class;
            default: return String.class;
        }   
    } 
};