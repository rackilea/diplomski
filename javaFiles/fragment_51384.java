// Collection of filters to be applied to your table
List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<>();

comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        if(filters.isEmpty())
            filters.add(RowFilter.regexFilter(comboBox.getSelectedItem().toString(), 2));
        else
            filters.set(0, RowFilter.regexFilter(comboBox.getSelectedItem().toString(), 2));
        // Apply filters
        sorter.setRowFilter(RowFilter.andFilter(filters));
    }
});

comboBox_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        if(filters.size() < 2)
            filters.add(RowFilter.regexFilter(comboBox_1.getSelectedItem().toString(), 3));
        else
            filters.set(1, RowFilter.regexFilter(comboBox_1.getSelectedItem().toString(), 3));
        // Apply filters
        sorter.setRowFilter(RowFilter.andFilter(filters));           
    }
});