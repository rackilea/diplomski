new javax.swing.JTable() {
    //Implement table header tool tips.
    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int index = columnModel.getColumnIndexAtX(p.x);
                int realIndex =  columnModel.getColumn(index).getModelIndex();
                return myToolTips[realIndex];
            }
        };
    }
};