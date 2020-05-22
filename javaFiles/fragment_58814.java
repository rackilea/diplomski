btnEdit.addActionListener(new ActionListener() {
    private boolean[] wasClickedTable = new boolean[table.getRowCount()];

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean chkDel = Boolean.valueOf(table.getValueAt(i, 0).toString());
            // A row should be processed
            if (chkDel) {
                // Lookup if row was already clicked before
                if(wasClickedTable[i]) {
                    // It was, skip the row and do not process it
                    continue;
                }
                // The row was not clicked before
                // However it is now, set it
                wasClickedTable[i] = true;                    

                // Further process the row
                // Your stuff
                ...
            }
        }
    }
});