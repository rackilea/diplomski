tblListOfInmates.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        try{
            int row = tblListOfInmates.getSelectedRow();
            Table_click = tblListOfInmates.getModel().getValueAt(row, 6).toString();

            if(rs.next()){