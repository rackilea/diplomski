scrollPane_1 = new JScrollPane();

scrollPane_1.setBounds(48, 104, 650, 314);
recordsPanel.add(scrollPane_1);

tblListOfInmates = new JTable(datas, columns){
    public boolean isCellEditable(int nRow, int nCol) {
        return false;
    }
};
scrollPane_1.setViewportView(tblListOfInmates);