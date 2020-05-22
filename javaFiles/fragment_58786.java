TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return colonnes.length; }
        public String getColumnName(int col) { return colonnes[col]; }
        public int getRowCount() { return Calcul.appartements.length; }
        public Object getValueAt(int row, int col) { Calcul.appartements[row][col]; }
    };
JTable table = new JTable(dataModel);