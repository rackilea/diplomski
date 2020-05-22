cEntertainment.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e){
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED) {
            ...
            newFilter(cEntertainment.getText());
        } else {
            ...
            removeFilter();
        }
    }
});

...

private void newFilter(String type) {
    RowFilter<DefaultTableModel,Object> rf = null;
    try{
        rf = RowFilter.regexFilter(type);
    }catch(java.util.regex.PatternSyntaxException e){
        return;
    }
    sorter.setRowFilter(rf);
}

private void removeFilter() {
    sorter.setRowFilter(null);
}